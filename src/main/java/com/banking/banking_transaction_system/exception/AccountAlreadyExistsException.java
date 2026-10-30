package com.banking.banking_transaction_system.exception;

// Custom exception for duplicate account numbers.
public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}