package com.kanapa4.loyalty_system.repository;

import com.kanapa4.loyalty_system.model.entity.LoyaltyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgram, Long> {
    boolean existsByName(String name);
}
