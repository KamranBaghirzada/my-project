package com.accountant.project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BalanceSheetResponse {

    private List<AssetResponse> totalAssets;
    private List<LiabilityResponse> totalLiability;
    private List<EquityResponse> totalEquity;
    private BalanceForAccountingTypeResponse balanceForEachAccountType;
}
