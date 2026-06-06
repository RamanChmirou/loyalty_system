package com.kanapa4.loyalty_system.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends LoyaltySystemException {
    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}