package com.kanapa4.loyalty_system.model.dto;

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
public class CreateLoyaltyProgramCommand {
    @NotBlank(message = "Program name is required")
    private String name;

    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
