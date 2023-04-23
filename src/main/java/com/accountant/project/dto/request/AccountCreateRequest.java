package com.accountant.project.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreateRequest {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
}
