package com.accountant.project.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AccountUpdateRequest {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
}
