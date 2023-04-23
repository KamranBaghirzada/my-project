package com.accountant.project.service.impl;

import com.accountant.project.dto.request.AccountRequest;
import com.accountant.project.dto.response.AccountResponse;
import com.accountant.project.mapper.AccountResponseConverter;
import com.accountant.project.model.Account;
import com.accountant.project.repository.AccountRepository;
import com.accountant.project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountResponseConverter accountResponseConverter;

    @Override
    public Page<AccountResponse> getAllAccountsWithSearch(Pageable pageable, AccountRequest request) {
        Page<Account> accountPage = accountRepository.findAll(pageable);
        return new PageImpl<>(accountPage.stream().map(accountResponseConverter::convert)
                .collect(Collectors.toList()), pageable, accountPage.getTotalElements());
    }

    @Override
    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(accountResponseConverter::convert).collect(Collectors.toList());
    }

    @Override
    public AccountResponse getOneAccountInDetail(Long accountId) {
        Account account = accountRepository
                .findById(accountId).orElseThrow(() ->
                        new RuntimeException("Account with number " + accountId + "does not exist."));
        return accountResponseConverter.convert(account);
    }

    @Override
    public AccountResponse addNewAccount(Account account) {
        return accountResponseConverter.convert(accountRepository.save(account));
    }

    @Override
    public AccountResponse changeAccount(Long accountId, Account account) {
        Optional<Account> updatedAccount = accountRepository.findById(accountId);
        if (updatedAccount.isPresent()) {
            Account oldAccount = updatedAccount.get();
            oldAccount.setFirstName(account.getFirstName());
            oldAccount.setLastName(account.getLastName());
            oldAccount.setPatronymic(account.getPatronymic());
            oldAccount.setFullName(account.getFullName());
            oldAccount.setBalance(account.getBalance());
            oldAccount.setCode(account.getCode());
            oldAccount.setEmail(account.getEmail());
            return accountResponseConverter.convert(accountRepository.save(oldAccount));
        }
        return null;
    }
}
