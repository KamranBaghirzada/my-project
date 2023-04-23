package com.accountant.project.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "last_edit_date")
    private LocalDate lastEditDate;

    @Column(name = "last_transaction_date")
    private LocalDate lastTransactionDate;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
