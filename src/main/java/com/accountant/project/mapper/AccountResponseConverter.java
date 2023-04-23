package com.accountant.project.mapper;


import com.accountant.project.dto.response.AccountResponse;
import com.accountant.project.model.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountResponseConverter implements Converter<Account, AccountResponse> {

    @Override
    public AccountResponse convert(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .name(account.getFirstName())
                .surname(account.getLastName())
                .created(account.getCreatedAt())
                .build();
    }
}
