package com.zaroyan.onlineWalletApp.repositories;

import com.zaroyan.onlineWalletApp.models.WalletEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Zaroyan
 */
@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<WalletEntity> findById(UUID uuid);
}
