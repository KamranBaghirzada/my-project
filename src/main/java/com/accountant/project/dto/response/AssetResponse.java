package com.accountant.project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AssetResponse {

    private String accountName;
    private BigDecimal balance;
}