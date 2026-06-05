package com.kanapa4.loyalty_system.model.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
