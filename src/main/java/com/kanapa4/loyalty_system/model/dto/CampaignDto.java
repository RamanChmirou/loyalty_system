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
public class CampaignDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Float multiplier;
    private Integer extraPoints;
    private EarningEventType targetEventType;
    private Long programId;
}
