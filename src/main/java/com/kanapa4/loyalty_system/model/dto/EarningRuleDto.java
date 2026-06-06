package com.kanapa4.loyalty_system.model.dto;

import com.kanapa4.loyalty_system.model.entity.EarningEventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EarningRuleDto {
    private Long id;
    private String name;
    private EarningEventType eventType;
    private int pointsAmount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean active;
}
