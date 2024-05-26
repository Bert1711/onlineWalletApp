package com.zaroyan.onlineWalletApp.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaroyan.onlineWalletApp.dto.WalletRequestDto;
import com.zaroyan.onlineWalletApp.models.WalletEntity;
import com.zaroyan.onlineWalletApp.services.WalletService;
import com.zaroyan.onlineWalletApp.utils.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zaroyan
 */

@WebMvcTest(WalletController.class)
public class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletService walletService;

    private WalletEntity walletEntity;
    private UUID walletId;

    @BeforeEach
    void setUp() {
        walletId = UUID.randomUUID();
        walletEntity = new WalletEntity(walletId, BigDecimal.valueOf(1000));
    }

    @Test
    public void testGetWallet() throws Exception {
        when(walletService.getWallet(walletId)).thenReturn(walletEntity);

        mockMvc.perform(get("/api/v1/wallets/{walletId}", walletId.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.walletId").value(walletId.toString()))
                .andExpect(jsonPath("$.amount").value(1000));

        verify(walletService, times(1)).getWallet(walletId);
    }

    @Test
    public void testTransferDeposit() throws Exception {
        WalletRequestDto walletRequest = createWalletRequest(OperationType.DEPOSIT, BigDecimal.valueOf(500));

        mockMvc.perform(post("/api/v1/wallet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(walletRequest)))
                .andExpect(status().isOk());

        verify(walletService, times(1)).transferDeposit(any(WalletEntity.class));
    }

    @Test
    public void testTransferWithdraw() throws Exception {
        WalletRequestDto walletRequest = createWalletRequest(OperationType.WITHDRAW, BigDecimal.valueOf(300));

        mockMvc.perform(post("/api/v1/wallet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(walletRequest)))
                .andExpect(status().isOk());

        verify(walletService, times(1)).transferWithdraw(any(WalletEntity.class));
    }

    private WalletRequestDto createWalletRequest(OperationType operationType, BigDecimal amount) {
        return new WalletRequestDto(walletId, operationType, amount);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
