package com.zaroyan.onlineWalletApp.repositories;

import com.zaroyan.onlineWalletApp.models.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Zaroyan
 */
@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {
}
