package com.accountant.project.controller;

import com.accountant.project.dto.request.AccountCreateRequest;
import com.accountant.project.dto.request.AccountUpdateRequest;
import com.accountant.project.dto.request.BalanceRequest;
import com.accountant.project.dto.response.AccountResponse;
import com.accountant.project.dto.response.BalanceSheetResponse;
import com.accountant.project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/version1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping()
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getOneAccountInDetail(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getOneAccountInDetail(id));
    }

    @PostMapping
    public ResponseEntity<AccountResponse> addAccount(@RequestBody AccountCreateRequest request) {
        return ResponseEntity.ok(accountService.addNewAccount(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> changeAccount(@PathVariable("id") Long id,
                                                         @RequestBody AccountUpdateRequest request) {
        return ResponseEntity.ok(accountService.changeAccount(id, request));
    }

    @PatchMapping("/change-balance")
    public ResponseEntity<String> changeBalance(@RequestBody BalanceRequest request) {
        return ResponseEntity.ok(accountService.changeBalance(request));
    }

    @GetMapping("/balance-sheet")
    public ResponseEntity<BalanceSheetResponse> getBalanceSheet() {
        return ResponseEntity.ok(accountService.getBalanceSheet());
    }
}