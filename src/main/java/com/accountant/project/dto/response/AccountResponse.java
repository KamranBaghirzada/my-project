package com.accountant.project.dto.response;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class AccountResponse {

    private UUID id;

    private String name;

    private String surname;

    private LocalDateTime created;

    private BigDecimal balance;

    private UUID code;
}
