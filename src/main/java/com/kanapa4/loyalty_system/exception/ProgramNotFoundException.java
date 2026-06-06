package com.kanapa4.loyalty_system.exception;

import org.springframework.http.HttpStatus;

public class ProgramNotFoundException extends LoyaltySystemException {
    public ProgramNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
