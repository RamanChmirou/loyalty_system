package com.kanapa4.loyalty_system.exception;

import org.springframework.http.HttpStatus;

public class MembershipAlreadyExistsException extends LoyaltySystemException {
    public MembershipAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}