package com.zaroyan.onlineWalletApp.controllers;

import com.zaroyan.onlineWalletApp.dto.WalletRequest;
import com.zaroyan.onlineWalletApp.dto.WalletResponse;
import com.zaroyan.onlineWalletApp.services.WalletService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

/**
 * @author Zaroyan
 */
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class WalletController {
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/wallets/{walletId}")
    public WalletResponse getWallet(@PathVariable UUID walletId) {
        return walletService.getWallet(walletId);
    }

    @PostMapping(value = "/wallet")
    public ResponseEntity<HttpStatus> transfer(@RequestBody @Valid WalletRequest walletRequest) throws IOException {
        walletService.transfer(walletRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
