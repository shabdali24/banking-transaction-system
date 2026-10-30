package com.banking.banking_transaction_system.dto;

import java.math.BigDecimal;

// DTO used to send account information back to the client.
public class AccountResponse {

    // Database-generated account ID.
    private Long id;

    // Bank account number.
    private String accountNumber;

    // Customer name.
    private String customerName;

    // Customer email.
    private String email;

    // Initial account balance will be 0.
    private BigDecimal balance;

    // Initial account status will be ACTIVE.
    private String status;

    public AccountResponse() {
    }

    // Constructor makes it easy for the service layer
    // to create a response object.
    public AccountResponse(
            Long id,
            String accountNumber,
            String customerName,
            String email,
            BigDecimal balance,
            String status) {

        this.id = id;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.email = email;
        this.balance = balance;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }
}