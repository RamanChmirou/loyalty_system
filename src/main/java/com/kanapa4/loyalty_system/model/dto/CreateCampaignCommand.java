package com.kanapa4.loyalty_system.model.dto;

import com.kanapa4.loyalty_system.model.entity.EarningEventType;
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
public class CreateCampaignCommand {
    @NotBlank(message = "Campaign name is required")
    private String name;

    private String description;

    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

    private Float multiplier;
    private Integer extraPoints;

    @NotNull(message = "Target event type is required")
    private EarningEventType targetEventType;

    private Long programId;
}
