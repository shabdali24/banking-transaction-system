package com.banking.banking_transaction_system.repository;

import com.banking.banking_transaction_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository layer is responsible for database operations on Account.
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Spring Data JPA will automatically create the query
    // based on the method name.
    boolean existsByAccountNumber(String accountNumber);
}