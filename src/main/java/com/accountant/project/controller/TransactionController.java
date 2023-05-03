package com.accountant.project.controller;

import com.accountant.project.dto.request.CashPurchaseRequest;
import com.accountant.project.service.impl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/version1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionServiceImpl transactionService;

    @PatchMapping("/credit-sale")
    public ResponseEntity<String> creditSaleTransaction(@RequestParam(name = "amount") BigDecimal amount) {
        transactionService.creditSaleTransaction(amount);
        return ResponseEntity.ok("credit-sale double entry - has been accounted. ");
    }

    @PostMapping("/cash-purchase")
    public ResponseEntity<String> cashPurchaseTransaction(@RequestBody CashPurchaseRequest request) {
        transactionService.cashPurchaseTransaction(request);
        return ResponseEntity.ok("Purchasing - material with cash has been accounted. ");
    }
}

