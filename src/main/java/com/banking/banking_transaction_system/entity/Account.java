package com.banking.banking_transaction_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

// @Entity tells JPA that this class should be mapped to a database table.
@Entity
public class Account {

    // Primary key of the account table.
    @Id

    // MySQL will automatically generate the ID.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Unique bank account number.
    private String accountNumber;

    // Name of the customer who owns the account.
    private String customerName;

    // Customer's email address.
    private String email;

    // Account balance.
    // BigDecimal is preferred for money instead of double/float.
    private BigDecimal balance;

    // Account status, for example ACTIVE or BLOCKED.
    private String status;

    // JPA requires a no-argument constructor.
    public Account() {
    }

    // Returns the generated database ID.
    public Long getId() {
        return id;
    }

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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}