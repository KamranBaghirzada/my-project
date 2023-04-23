package com.accountant.project.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AccountResponse {

    private String name;

    private String surname;

    private LocalDate created;
}
