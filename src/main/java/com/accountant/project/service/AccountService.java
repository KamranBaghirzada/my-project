package com.accountant.project.service;

import com.accountant.project.dto.request.AccountRequest;
import com.accountant.project.dto.response.AccountResponse;
import com.accountant.project.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {

    Page<AccountResponse> getAllAccountsWithSearch(Pageable pageable, AccountRequest request);

    List<AccountResponse> getAllAccounts();

    AccountResponse getOneAccountInDetail(Long accountId);

    AccountResponse addNewAccount(Account account);

    AccountResponse changeAccount(Long accountId,Account account);
}
