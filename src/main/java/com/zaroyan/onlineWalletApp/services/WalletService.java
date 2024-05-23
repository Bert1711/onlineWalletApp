package com.zaroyan.onlineWalletApp.services;

import com.zaroyan.onlineWalletApp.dto.WalletRequest;
import com.zaroyan.onlineWalletApp.dto.WalletResponse;
import com.zaroyan.onlineWalletApp.models.WalletEntity;
import com.zaroyan.onlineWalletApp.repositories.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public WalletEntity getWallet(UUID walletId) {
       Optional<WalletEntity> walletEntityOptional = walletRepository.findById(walletId);
        if (walletEntityOptional.isPresent()) {
            return walletEntityOptional.get();
        } else {
            throw new NullPointerException("Кошелёк не найден");
        }
    }

    public void transferDeposit(WalletEntity wallet) {
        Optional<WalletEntity> walletEntityOptional = walletRepository.findById(wallet.getWalletId());
        if(walletEntityOptional.isPresent()) {
            WalletEntity walletEntity = walletEntityOptional.get();

        }

    }

    public void transferWithdraw(WalletEntity walletEntity) {
    }
}
