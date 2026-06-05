package com.kanapa4.loyalty_system.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "earning_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EarningRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EarningEventType eventType;

    @Column(nullable = false)
    private int pointsAmount;

    @Embedded
    private Period validityPeriod;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private LoyaltyProgram program;
}
