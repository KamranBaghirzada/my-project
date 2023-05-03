package com.accountant.project.service;

import com.accountant.project.dto.request.AccountCreateRequest;
import com.accountant.project.dto.request.AccountUpdateRequest;
import com.accountant.project.dto.request.BalanceRequest;
import com.accountant.project.dto.response.AccountResponse;
import com.accountant.project.dto.response.BalanceSheetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {

    Page<AccountResponse> getAllAccountsWithSearch(Pageable pageable, AccountCreateRequest request);

    List<AccountResponse> getAllAccounts();

    AccountResponse getOneAccountInDetail(Long id);

    AccountResponse addNewAccount(AccountCreateRequest request);

    AccountResponse changeAccount(Long id, AccountUpdateRequest request);

    String changeBalance(BalanceRequest request);

    BalanceSheetResponse getBalanceSheet();
}
