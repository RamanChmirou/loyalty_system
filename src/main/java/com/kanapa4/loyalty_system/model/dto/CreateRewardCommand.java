package com.kanapa4.loyalty_system.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRewardCommand {
    @NotBlank(message = "Reward name is required")
    private String name;

    private String description;

    @Min(value = 1, message = "Points cost must be at least 1")
    private int pointsCost;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean active;
}
