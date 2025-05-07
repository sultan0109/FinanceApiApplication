package com.example.Finance_api.entity;
import lombok.*;

import javax.persistence.*;
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
    private UserInfo user;

    private BigDecimal amount;

    private String description;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private TransactionType type;
}
