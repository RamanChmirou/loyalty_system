package com.kanapa4.loyalty_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(LoyaltySystemException.class)
    public ResponseEntity<ProblemDetail> handleMedicalClinicException(LoyaltySystemException exception) {
        HttpStatus status = exception.getHttpStatus();

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                status,
                exception.getMessage()
        );

        return ResponseEntity.status(status).body(problemDetail);
    }
}
