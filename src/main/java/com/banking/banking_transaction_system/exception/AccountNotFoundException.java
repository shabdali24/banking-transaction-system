package com.banking.banking_transaction_system.exception;

// Exception thrown when an account is not found
// Custom exception used when the requested account does not exist.
public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message) {
        super(message);
    }

}
