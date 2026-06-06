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
public class MembershipDto {
    private Long id;
    private Long programId;
    private String programName;
    private LocalDateTime joinDate;
    private int pointsBalance;
}
