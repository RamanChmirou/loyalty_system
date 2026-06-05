package com.kanapa4.loyalty_system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EarningEventType {
    PURCHASE("Purchase"),
    REVIEW("Review"),
    REFERRAL("Referral"),
    OTHER("Other");

    private final String name;
}
