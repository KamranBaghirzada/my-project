package com.accountant.project.mapper;

import com.accountant.project.dto.request.AccountCreateRequest;
import com.accountant.project.model.Account;
import com.accountant.project.model.AccountType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter implements Converter<AccountCreateRequest, Account> {

    @Override
    public Account convert(AccountCreateRequest request) {
        return Account.builder()
                .accountName(request.getName())
                .description(request.getDescription())
                .accountType(AccountType.fromNumber(request.getAccountType()))
                .build();
    }
}
