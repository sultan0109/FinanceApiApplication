package com.example.Finance_api.dto;

import com.example.Finance_api.entity.Transaction;
import com.example.Finance_api.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionDto dto, UserInfo user) {
        return Transaction.builder()
                .user(user)
                .amount(dto.getAmount())
                .description(dto.getDescription())
                .type(dto.getType())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public TransactionResponseDto toDto(Transaction tx) {
        TransactionResponseDto dto = new TransactionResponseDto();
        dto.setId(tx.getId());
        dto.setUserId(tx.getUser().getId());
        dto.setAmount(tx.getAmount());
        dto.setDescription(tx.getDescription());
        dto.setCreatedAt(tx.getCreatedAt());
        dto.setType(tx.getType());
        return dto;
    }
}
