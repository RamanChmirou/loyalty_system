package com.kanapa4.loyalty_system.exception;

import org.springframework.http.HttpStatus;

public class MembershipNotFoundException extends LoyaltySystemException {
    public MembershipNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}