package com.accountant.project.repository;


import com.accountant.project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AccountRepository extends JpaRepository<Account, UUID> {

}
