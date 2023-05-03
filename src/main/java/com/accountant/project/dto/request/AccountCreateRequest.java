package com.accountant.project.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreateRequest {

    private String name;
    private String description;
    private Integer accountType;
}
