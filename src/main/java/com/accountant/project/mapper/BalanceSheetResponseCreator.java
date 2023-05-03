package com.accountant.project.mapper;

import com.accountant.project.dto.response.*;
import com.accountant.project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BalanceSheetResponseCreator {

    private final AccountRepository accountRepository;
    private final AssetResponseConverter assetResponseConverter;
    private final LiabilityResponseConverter liabilityResponseConverter;
    private final EquityResponseConverter equityResponseConverter;
    private final BalanceForAccountingTypeResponseConverter balanceForAccountingTypeResponseConverter;

    public BalanceSheetResponse createBalanceSheet() {
        return BalanceSheetResponse.builder()
                .totalAssets(getTotalAsset())
                .totalLiability(getTotalLiability())
                .totalEquity(getTotalEquity())
                .balanceForEachAccountType(balanceForAccountingTypeResponseConverter.create())
                .build();
    }

    public List<AssetResponse> getTotalAsset() {
        return accountRepository.findAll()
                .stream().filter(s -> "ASSET".equalsIgnoreCase(s.getAccountType().toString()))
                .map(assetResponseConverter::convert)
                .collect(Collectors.toList());
    }

    public List<LiabilityResponse> getTotalLiability() {
        return accountRepository.findAll()
                .stream().filter(s -> "LIABILITY".equalsIgnoreCase(s.getAccountType().toString()))
                .map(liabilityResponseConverter::convert)
                .collect(Collectors.toList());
    }

    public List<EquityResponse> getTotalEquity() {
        return accountRepository.findAll()
                .stream().filter(s -> "CAPITAL".equalsIgnoreCase(s.getAccountType().toString()))
                .map(equityResponseConverter::convert)
                .collect(Collectors.toList());
    }
}
