package com.zaroyan.onlineWalletApp.services;

import com.zaroyan.onlineWalletApp.exceptions.InsufficientFundsException;
import com.zaroyan.onlineWalletApp.exceptions.WalletNotFoundException;
import com.zaroyan.onlineWalletApp.models.WalletEntity;
import com.zaroyan.onlineWalletApp.repositories.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Zaroyan
 */
@Service
@Slf4j

public class WalletService {
    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional(timeout = 30, readOnly = true)
    public WalletEntity getWallet(UUID walletId) {
       Optional<WalletEntity> walletEntityOptional = walletRepository.findById(walletId);
        if (walletEntityOptional.isPresent()) {
            return walletEntityOptional.get();
        } else {
            throw new WalletNotFoundException("Кошелёк не найден");
        }
    }

    @Transactional(timeout = 30, rollbackFor = Exception.class)
    public void transferDeposit(WalletEntity deposit) {
        Optional<WalletEntity> walletEntityOptional = walletRepository.findById(deposit.getWalletId());
        if(walletEntityOptional.isPresent()) {
            WalletEntity walletEntity = walletEntityOptional.get();
            walletEntity.setAmount(walletEntity.getAmount().add(deposit.getAmount()));
            walletRepository.save(walletEntity);
        } else {
            throw new WalletNotFoundException("Кошелёк не найден");
        }
    }

    @Transactional(timeout = 30, rollbackFor = Exception.class)
    public void transferWithdraw(WalletEntity withdraw) {
        Optional<WalletEntity> walletEntityOptional = walletRepository.findById(withdraw.getWalletId());
        if(walletEntityOptional.isPresent()) {
            WalletEntity walletEntity = walletEntityOptional.get();
            if (walletEntity.getAmount().compareTo(withdraw.getAmount()) < 0) {
                throw new InsufficientFundsException("Недостаточно средств");
            }
            walletEntity.setAmount(walletEntity.getAmount().subtract(withdraw.getAmount()));
            walletRepository.save(walletEntity);
        } else {
            throw new WalletNotFoundException("Кошелёк не найден");
        }
    }
}
