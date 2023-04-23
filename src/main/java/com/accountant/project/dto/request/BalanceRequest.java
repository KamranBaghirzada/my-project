package com.accountant.project.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class BalanceRequest {

    private UUID id;
    private String operation;
    private BigDecimal amount;
}
