package com.example.Finance_api.dto;

import com.example.Finance_api.entity.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponseDto {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private String description;
    private LocalDateTime createdAt;
    private TransactionType type;
}