package com.kanapa4.loyalty_system.model.dto;

import com.kanapa4.loyalty_system.model.entity.EarningEventType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEarningRuleCommand {
    @NotBlank(message = "Rule name is required")
    private String name;

    @NotNull(message = "Event type is required")
    private EarningEventType eventType;

    @Min(value = 1, message = "Points amount must be at least 1")
    private int pointsAmount;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean active;
}
