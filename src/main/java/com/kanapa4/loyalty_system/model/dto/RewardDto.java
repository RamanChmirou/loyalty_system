package com.kanapa4.loyalty_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RewardDto {
    private Long id;
    private String name;
    private String description;
    private int pointsCost;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean active;
}
