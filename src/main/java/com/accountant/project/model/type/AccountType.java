package com.accountant.project.model.type;

import com.accountant.project.model.Account;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "type_accounts")
@NoArgsConstructor
@AllArgsConstructor
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "value")
    private String value;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "accountType")
    private List<Account> accounts;
}
