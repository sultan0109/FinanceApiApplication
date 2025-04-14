package com.example.Finance_api.dto;

import com.example.Finance_api.entity.TransactionType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {
    private Long userId;
    private BigDecimal amount;
    private String description;
    private TransactionType type;
}