package com.kanapa4.loyalty_system.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "memberships", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "program_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private LoyaltyProgram program;

    @CreationTimestamp
    private LocalDateTime joinDate;

    @Builder.Default
    private int pointsBalance = 0;

    @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL)
    private List<PointsTransaction> transactions;
}
