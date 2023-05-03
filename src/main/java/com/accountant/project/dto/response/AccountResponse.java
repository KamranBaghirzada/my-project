package com.accountant.project.dto.response;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal balance;
}
