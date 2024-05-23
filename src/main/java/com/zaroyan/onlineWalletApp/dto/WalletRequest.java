package com.zaroyan.onlineWalletApp.dto;

import com.zaroyan.onlineWalletApp.utils.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Zaroyan
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class WalletRequest {
    private UUID walletId;
    private BigDecimal amount;
    private OperationType operationType;
}
