package com.accountant.project.mapper;

import com.accountant.project.dto.response.EquityResponse;
import com.accountant.project.model.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EquityResponseConverter implements Converter<Account, EquityResponse> {

    @Override
    public EquityResponse convert(Account account) {
        return EquityResponse.builder()
                .accountName(account.getAccountName())
                .balance(account.getBalance())
                .build();
    }
}
