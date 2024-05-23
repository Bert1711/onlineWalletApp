package com.zaroyan.onlineWalletApp.services;

import com.zaroyan.onlineWalletApp.repositories.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
