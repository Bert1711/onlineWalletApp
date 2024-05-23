package com.zaroyan.onlineWalletApp.repositories;

import com.zaroyan.onlineWalletApp.models.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Zaroyan
 */
public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {
}
