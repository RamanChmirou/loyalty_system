package com.kanapa4.loyalty_system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LoyaltySystemException extends RuntimeException {
    private final HttpStatus httpStatus;

    public LoyaltySystemException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
