package com.kanapa4.loyalty_system.model.dto;

import com.kanapa4.loyalty_system.model.entity.EarningEventType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EarnPointsCommand {
    @NotNull(message = "Event type is required to earn points")
    private EarningEventType eventType;
}
