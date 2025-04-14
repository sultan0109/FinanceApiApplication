package com.example.Finance_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",schema = "user")
@Builder
public class User  extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private String password;


}
