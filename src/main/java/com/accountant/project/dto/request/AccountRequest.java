package com.accountant.project.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRequest {

    private String name;

    private String surname;
}
