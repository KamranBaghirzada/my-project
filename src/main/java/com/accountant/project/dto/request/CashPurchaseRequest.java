package com.accountant.project.dto.request;

import com.accountant.project.model.Material;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CashPurchaseRequest {

    private Material material;
    private BigDecimal amount;
    private Long purchaserId;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime purchaseDate;
}
