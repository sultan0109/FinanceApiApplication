package com.example.Finance_api.service;

import com.example.Finance_api.dto.TransactionDto;
import com.example.Finance_api.dto.TransactionResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    TransactionResponseDto create(TransactionDto dto);

    List<TransactionResponseDto> getAll();

    List<TransactionResponseDto> getByUser(Long userId);

    List<TransactionResponseDto> getByUserAndDate(Long userId, LocalDateTime from, LocalDateTime to);
}
