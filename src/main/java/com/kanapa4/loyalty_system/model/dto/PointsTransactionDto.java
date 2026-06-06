package com.kanapa4.loyalty_system.model.dto;

import com.kanapa4.loyalty_system.model.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointsTransactionDto {
    private Long id;
    private TransactionType type;
    private int pointsAmount;
    private String description;
    private LocalDateTime transactionDate;
    private String programName;
}
