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

    public WalletResponse getWallet(UUID walletId) {
    }

    public void transfer(WalletEntity wallet) {
    }
}
