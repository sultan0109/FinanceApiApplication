package com.example.Finance_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "transactions",schema = "info")
public class Transaction extends BaseEntity {

    @ManyToOne
    private User user;

    private BigDecimal amount;

    private String description;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private TransactionType type;
}
