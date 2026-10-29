package com.banking.banking_transaction_system.service;

import com.banking.banking_transaction_system.dto.AccountRequest;
import com.banking.banking_transaction_system.dto.AccountResponse;
import com.banking.banking_transaction_system.entity.Account;
import com.banking.banking_transaction_system.exception.AccountAlreadyExistsException;
import com.banking.banking_transaction_system.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

// @Service tells Spring that this class contains business logic.
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    // Constructor injection is the recommended way
    // to inject dependencies into a Spring service.
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // @Transactional makes the database operation part
    // of a single transaction.
    @Transactional
    public AccountResponse createAccount(AccountRequest request) {

        // Step 1: Check whether the account number already exists.
        if (accountRepository.existsByAccountNumber(request.getAccountNumber())) {
            throw new AccountAlreadyExistsException("Account number already exists");
        }

        // Step 2: Convert the incoming DTO into an entity.
        Account account = new Account();

        account.setAccountNumber(request.getAccountNumber());
        account.setCustomerName(request.getCustomerName());
        account.setEmail(request.getEmail());

        // New account always starts with zero balance.
        account.setBalance(BigDecimal.ZERO);

        // New account is active by default.
        account.setStatus("ACTIVE");

        // Step 3: Save the entity into MySQL.
        Account savedAccount = accountRepository.save(account);

        // Step 4: Convert the saved entity into a response DTO.
        return new AccountResponse(
                savedAccount.getId(),
                savedAccount.getAccountNumber(),
                savedAccount.getCustomerName(),
                savedAccount.getEmail(),
                savedAccount.getBalance(),
                savedAccount.getStatus()
        );
    }
}