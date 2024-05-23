package com.zaroyan.onlineWalletApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Zaroyan
 */
@Entity
public class WalletEntity {
    @Id
    private UUID walletId;
    private BigDecimal amount;

}
