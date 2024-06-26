package com.zaroyan.onlineWalletApp.controllers;

import com.zaroyan.onlineWalletApp.dto.WalletRequestDto;
import com.zaroyan.onlineWalletApp.dto.WalletResponseDto;
import com.zaroyan.onlineWalletApp.models.WalletEntity;
import com.zaroyan.onlineWalletApp.services.WalletService;
import com.zaroyan.onlineWalletApp.utils.OperationType;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    public ResponseEntity<WalletEntity> getWallet(@PathVariable UUID walletId) {
        log.info("Поступил запрос на информацию баланса кошелька с id: " + walletId.toString());
        return ResponseEntity.ok(walletService.getWallet(walletId));
    }

    @PostMapping(value = "/wallet")
    public ResponseEntity<HttpStatus> transfer(@RequestBody @Valid WalletRequestDto walletRequest) throws IOException {

        if (walletRequest.getOperationType() == OperationType.DEPOSIT) {
            walletService.transferDeposit(convertToWallet(walletRequest));
            log.info("Выполнено пополнение кошелька на сумму: " + walletRequest.getAmount());
        } else if (walletRequest.getOperationType() == OperationType.WITHDRAW) {
            walletService.transferWithdraw(convertToWallet(walletRequest));
            log.info("Выполнен вывод средств на сумму: " + walletRequest.getAmount());
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private WalletEntity convertToWallet(WalletRequestDto walletRequest) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(walletRequest, WalletEntity.class);
    }

    private WalletResponseDto convertToWalletResponse(WalletEntity walletEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(walletEntity, WalletResponseDto.class);
    }
}
