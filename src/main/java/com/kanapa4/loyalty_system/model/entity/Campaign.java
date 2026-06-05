package com.kanapa4.loyalty_system.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "campaigns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Embedded
    private Period activityPeriod;

    @Builder.Default
    private Float multiplier = 1.0f;

    @Builder.Default
    private Integer extraPoints = 0;

    @Enumerated(EnumType.STRING)
    private EarningEventType targetEventType;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private LoyaltyProgram program;
}
