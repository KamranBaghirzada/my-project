package com.accountant.project.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "kg_transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "transaction_name")
    private String transactionName;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "debit_account_id")
    private Account debitAccount;

    @ManyToOne
    @JoinColumn(name = "credit_account_id")
    private Account creditAccount;

    @CreationTimestamp
    @Column(name = "transaction_date")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "last_transaction_type")
    private TransactionType lastTransactionType;
}
