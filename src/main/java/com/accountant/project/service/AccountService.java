package com.accountant.project.service;

import com.accountant.project.dto.request.AccountCreateRequest;
import com.accountant.project.dto.request.AccountUpdateRequest;
import com.accountant.project.dto.request.BalanceRequest;
import com.accountant.project.dto.response.AccountResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Page<AccountResponse> getAllAccountsWithSearch(Pageable pageable, AccountCreateRequest request);

    List<AccountResponse> getAllAccounts();

    AccountResponse getOneAccountInDetail(UUID id);

    AccountResponse addNewAccount(AccountCreateRequest request);

    AccountResponse changeAccount(UUID id, AccountUpdateRequest request);

    String changeBalance(BalanceRequest request);
}
