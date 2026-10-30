package com.banking.banking_transaction_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// DTO = Data Transfer Object.
// This class represents the data that the client sends to our API.
public class AccountRequest {

    // Account number is mandatory.
    @NotBlank(message = "Account number is required")
    private String accountNumber;

    // Customer name is mandatory.
    @NotBlank(message = "Customer name is required")
    private String customerName;

    // Email is mandatory and must have a valid email format.
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    // No balance or status from the client.
    // Our backend will set:
    // balance = 0
    // status = ACTIVE

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

