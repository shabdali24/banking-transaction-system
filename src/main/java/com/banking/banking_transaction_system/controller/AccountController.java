package com.banking.banking_transaction_system.controller;

import com.banking.banking_transaction_system.dto.AccountRequest;
import com.banking.banking_transaction_system.dto.AccountResponse;
import com.banking.banking_transaction_system.service.AccountService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController tells Spring that this class handles REST API requests.
@RestController

// Base URL for all account-related APIs.
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    // Constructor injection for AccountService.
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Handles POST /api/accounts
    // @RequestBody converts JSON request data into AccountRequest.
    // @Valid triggers the validation annotations in AccountRequest.
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(
            @Valid @RequestBody AccountRequest request) {

        // Controller delegates the actual business logic to the service.
        AccountResponse response = accountService.createAccount(request);

        // HTTP 201 means a new resource was successfully created.
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}