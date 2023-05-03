package com.accountant.project.mapper;

import com.accountant.project.dto.response.AssetResponse;
import com.accountant.project.model.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AssetResponseConverter implements Converter<Account, AssetResponse> {

    @Override
    public AssetResponse convert(Account account) {
        return AssetResponse.builder()
                .accountName(account.getAccountName())
                .balance(account.getBalance())
                .build();
    }
}
