package com.accountant.project.service;

import com.accountant.project.dto.request.CashPurchaseRequest;

import java.math.BigDecimal;

public interface TransactionService {

    void creditSaleTransaction(BigDecimal amount);
    void cashPurchaseTransaction(CashPurchaseRequest request);
}
