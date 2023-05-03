package com.accountant.project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BalanceForAccountingTypeResponse {

    private BigDecimal totalAsset;
    private BigDecimal totalLiability;
    private BigDecimal totalEquity;
}
