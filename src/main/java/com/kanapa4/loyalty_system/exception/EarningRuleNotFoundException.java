package com.kanapa4.loyalty_system.exception;

import org.springframework.http.HttpStatus;

public class EarningRuleNotFoundException extends LoyaltySystemException {
    public EarningRuleNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
