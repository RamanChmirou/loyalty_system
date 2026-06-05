package com.kanapa4.loyalty_system.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "loyalty_programs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @Embedded
    private Period validityPeriod;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Membership> members;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<EarningRule> earningRules;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Reward> rewards;
}
