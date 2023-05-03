package com.accountant.project.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "kg_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "description")
    private String description;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "last_transaction_amount")
    private BigDecimal lastTransactionAmount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @OneToMany(mappedBy = "creditAccount")
    private List<Transaction> creditTransaction;

    @OneToMany(mappedBy = "debitAccount")
    private List<Transaction> debitTransaction;
}
