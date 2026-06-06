package com.kanapa4.loyalty_system.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends LoyaltySystemException {
    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}