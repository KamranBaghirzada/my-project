package com.accountant.project.mapper;

import com.accountant.project.dto.response.BalanceForAccountingTypeResponse;
import com.accountant.project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BalanceForAccountingTypeResponseConverter {

    private final AccountRepository accountRepository;

    public BalanceForAccountingTypeResponse create() {
        return BalanceForAccountingTypeResponse.builder()
                .totalAsset(accountRepository.getTotalAssetBalance())
                .totalLiability(accountRepository.getTotalLiabilityBalance())
                .totalEquity(accountRepository.getTotalEquity())
                .build();
    }
}
