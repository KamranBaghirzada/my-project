package com.accountant.project.repository;


import com.accountant.project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;


public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT SUM(a.balance) as total_balance FROM Account a WHERE a.accountType = 'ASSET'")
    BigDecimal getTotalAssetBalance();

    @Query("SELECT SUM(a.balance) as total_balance FROM Account a WHERE a.accountType = 'LIABILITY'")
    BigDecimal getTotalLiabilityBalance();

    @Query("SELECT SUM(a.balance) as total_balance FROM Account a WHERE a.accountType = 'CAPITAL'")
    BigDecimal getTotalEquity();

    Account findByAccountName(String cash);
}
