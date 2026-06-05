package com.kanapa4.loyalty_system.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rewards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private int pointsCost;

    @Embedded
    private Period availabilityPeriod;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private LoyaltyProgram program;
}
