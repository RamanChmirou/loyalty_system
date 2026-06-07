package com.kanapa4.loyalty_system.repository;

import com.kanapa4.loyalty_system.model.entity.EarningRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EarningRuleRepository extends JpaRepository<EarningRule, Long> {
    List<EarningRule> findByProgramId(Long programId);
}
