package com.example.Finance_api.serviceImpl;

import com.example.Finance_api.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionLogService {

    @Async
    public void logTransactionAsync(Transaction transaction) {
        // тут можно писать в файл, отправлять в Kafka, Sentry и т.п.
        System.out.println("Logging transaction: " + transaction.getId());
    }
}
