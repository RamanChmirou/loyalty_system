package com.kanapa4.loyalty_system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionType {
    EARN("Earn points"),
    REDEEM("Redeem points");

    private final String displayName;
}
