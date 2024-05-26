package com.zaroyan.onlineWalletApp.dto;

import com.zaroyan.onlineWalletApp.utils.OperationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Zaroyan
 */
@Data
@Builder
@AllArgsConstructor // Добавляем аннотацию AllArgsConstructor
public class WalletRequestDto {

    @NotNull(message = "Идентификатор кошелька не указан.")
    private UUID walletId;

    @NotNull(message = "Тип операции не указан.")
    private OperationType operationType;

    @NotNull(message = "Сумма не указана.")
    @Min(value = 1, message = "Сумма должна быть больше 0.")
    private BigDecimal amount;
}
