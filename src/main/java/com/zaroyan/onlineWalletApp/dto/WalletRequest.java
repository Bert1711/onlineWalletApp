package com.zaroyan.onlineWalletApp.dto;

import com.zaroyan.onlineWalletApp.utils.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Zaroyan
 */
public class WalletRequest {
    private UUID walletId;
    private BigDecimal amount;
    private OperationType operationType;
}
