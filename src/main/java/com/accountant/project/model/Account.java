package com.accountant.project.model;


import com.accountant.project.model.type.AccountType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "code")
    private String code;

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "is_locked")
    private Boolean isLocked;

    @Transient
    private String fullName;

    @PostLoad
    public void initData() {
        this.fullName = this.lastName + " " + this.firstName + " " + this.patronymic;
    }

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_type")
    private AccountType accountType;
}
