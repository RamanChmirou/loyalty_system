package com.kanapa4.loyalty_system.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "points_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PointsTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false)
    private int pointsAmount;

    private String description;

    @CreationTimestamp
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "membership_id", nullable = false)
    private Membership membership;

    @ManyToOne
    @JoinColumn(name = "earning_rule_id")
    private EarningRule earningRule;

    @ManyToOne
    @JoinColumn(name = "reward_id")
    private Reward reward;
}
