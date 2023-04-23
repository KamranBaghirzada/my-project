package com.accountant.project.service.impl;

import com.accountant.project.dto.request.AccountCreateRequest;
import com.accountant.project.dto.request.AccountUpdateRequest;
import com.accountant.project.dto.request.BalanceRequest;
import com.accountant.project.dto.response.AccountResponse;
import com.accountant.project.mapper.AccountConverter;
import com.accountant.project.mapper.AccountResponseConverter;
import com.accountant.project.model.Account;
import com.accountant.project.repository.AccountRepository;
import com.accountant.project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountResponseConverter accountResponseConverter;

    private final AccountConverter accountConverter;

    @Override
    public Page<AccountResponse> getAllAccountsWithSearch(Pageable pageable, AccountCreateRequest request) {
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
    public AccountResponse getOneAccountInDetail(UUID id) {
        Account account = accountRepository
                .findById(id).orElseThrow(() ->
                        new RuntimeException("Account with number " + id + "does not exist."));
        return accountResponseConverter.convert(account);
    }

    @Override
    public AccountResponse addNewAccount(AccountCreateRequest request) {
        Account account = accountConverter.convert(request);
        return accountResponseConverter.convert(accountRepository.save(account));
    }

    @Override
    public AccountResponse changeAccount(UUID id, AccountUpdateRequest request) {
        Optional<Account> updatedAccount = accountRepository.findById(id);
        if (updatedAccount.isPresent()) {
            Account update = updatedAccount.get();
            update.setFirstName(request.getFirstName());
            update.setLastName(request.getLastName());
            update.setPatronymic(request.getPatronymic());
            return accountResponseConverter.convert(accountRepository.save(update));
        }
        return null;
    }

    @Override
    public String changeBalance(BalanceRequest request) {
        return "Your account balance now consists of " + updateBalance(request) + " US $";
    }

    public BigDecimal updateBalance(BalanceRequest request) {
        Account account = accountRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Account with account number of " + request.getId() + " does not exist"));
        switch (request.getOperation()) {
            case "add":
                return account.getBalance().add(request.getAmount());
            case "subtract":
                return account.getBalance().subtract(request.getAmount());
            default:
                throw new IllegalArgumentException("Invalid operation: " + request.getOperation());
        }
    }
}
