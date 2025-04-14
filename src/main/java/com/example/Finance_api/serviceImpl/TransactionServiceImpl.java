package com.example.Finance_api.serviceImpl;

import com.example.Finance_api.dto.TransactionDto;
import com.example.Finance_api.dto.TransactionMapper;
import com.example.Finance_api.dto.TransactionResponseDto;
import com.example.Finance_api.entity.Transaction;
import com.example.Finance_api.entity.TransactionType;
import com.example.Finance_api.entity.User;
import com.example.Finance_api.repo.TransactionRepository;
import com.example.Finance_api.repo.UserRepository;
import com.example.Finance_api.service.TransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final UserRepository userRepo;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    @Transactional // если на база стоит рид коммитет
    public TransactionResponseDto create(TransactionDto request) {
        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        BigDecimal amount = request.getAmount();
        TransactionType type = request.getType();

        if (type == TransactionType.CREDIT) {
            if (user.getBalance().compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient balance");
            }
            user.setBalance(user.getBalance().subtract(amount));
        } else if (type == TransactionType.DEBIT) {
            user.setBalance(user.getBalance().add(amount));
        } else {
            throw new RuntimeException("Unknown transaction type");
        }

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setCreatedAt(LocalDateTime.now());

        Transaction savedTransaction = transactionRepository.save(transaction);

        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setId(savedTransaction.getId());
        responseDto.setUserId(savedTransaction.getUser().getId());
        responseDto.setAmount(savedTransaction.getAmount());
        responseDto.setType(savedTransaction.getType());
        responseDto.setCreatedAt(savedTransaction.getCreatedAt());
        responseDto.setDescription("Transaction " + savedTransaction.getType().name());

        return responseDto;

    }

    public List<TransactionResponseDto> getAll() {
        return transactionRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<TransactionResponseDto> getByUser(Long userId) {
        return transactionRepository.findByUserId(userId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<TransactionResponseDto> getByUserAndDate(Long userId, LocalDateTime from, LocalDateTime to) {
        return transactionRepository.findByUserIdAndCreatedAtBetween(userId, from, to).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}