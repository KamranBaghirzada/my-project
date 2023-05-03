package com.accountant.project.mapper;

import com.accountant.project.dto.response.LiabilityResponse;
import com.accountant.project.model.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LiabilityResponseConverter implements Converter<Account, LiabilityResponse> {

    @Override
    public LiabilityResponse convert(Account account) {
        return LiabilityResponse.builder()
                .accountName(account.getAccountName())
                .balance(account.getBalance())
                .build();
    }
}
