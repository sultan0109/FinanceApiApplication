package com.example.Finance_api.rest;

import com.example.Finance_api.dto.TransactionDto;
import com.example.Finance_api.dto.TransactionResponseDto;
import com.example.Finance_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponseDto create(@RequestBody TransactionDto dto) {
        return transactionService.create(dto);
    }

    @GetMapping
    public List<TransactionResponseDto> all() {
        return transactionService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<TransactionResponseDto> byUser(@PathVariable Long userId) {
        return transactionService.getByUser(userId);
    }

    @GetMapping("/user/{userId}/range")
    public List<TransactionResponseDto> byUserAndDate(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        return transactionService.getByUserAndDate(userId, from, to);
    }
}