package com.accountant.project.controller;


import com.accountant.project.dto.response.AccountResponse;
import com.accountant.project.model.Account;
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

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getOneAccountInDetail(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getOneAccountInDetail(accountId));
    }

    @PostMapping("/add-account")
    public ResponseEntity<AccountResponse> addAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.addNewAccount(account));
    }

    @PutMapping("/change-account/{accountId}")
    public ResponseEntity<AccountResponse> changeAccount(@PathVariable Long accountId,
                                                         @RequestBody Account account) {
        return ResponseEntity.ok(accountService.changeAccount(accountId, account));
    }
}
