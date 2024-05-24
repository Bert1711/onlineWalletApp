package com.zaroyan.onlineWalletApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Zaroyan
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "wallets")
public class WalletEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID walletId;
    private BigDecimal amount;
}



//    UUID состоит из 32 шестнадцатеричных (hexadecimal*) цифр, разделенных дефисами
//    Этот формат состоит из пяти групп цифр:
//
//      Группа 1: 8 символов
//      Группа 2: 4 символа
//      Группа 3: 4 символа
//      Группа 4: 4 символа
//      Группа 5: 12 символов


//      Cписок шестнадцатеричных цифр:
//      0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F.
