package com.kanapa4.loyalty_system.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedeemPointsCommand {
    @NotNull(message = "Reward ID is required")
    private Long rewardId;
}
