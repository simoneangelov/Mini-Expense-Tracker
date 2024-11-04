package com.example.mini_expense_tracker.exception;

// This is a custom exception class that extends RuntimeException.
// It is used to handle resource not found exceptions in the application.

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
