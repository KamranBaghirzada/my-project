package com.accountant.project.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BalanceRequest {

    private Long id;
    private String operation;
    private BigDecimal amount;
}
