package com.banking.banking_transaction_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Handles exceptions globally for all REST controllers.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles duplicate account numbers.
    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<String> handleAccountAlreadyExists(
            AccountAlreadyExistsException exception) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }

    // Handles validation errors from @Valid.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        // Extract each field's validation error.
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    // Handles database-level unique constraint violations.
// This protects us if two requests try to create the same account
// at nearly the same time.
@ExceptionHandler(DataIntegrityViolationException.class)
public ResponseEntity<String> handleDataIntegrityViolation(
        DataIntegrityViolationException exception) {

    return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Account number already exists");
}
}