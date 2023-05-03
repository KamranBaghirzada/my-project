package com.accountant.project.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountUpdateRequest {

    private String name;
    private String description;
    private BigDecimal balance;
    private Integer accountType;
}
