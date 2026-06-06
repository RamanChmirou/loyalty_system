package com.kanapa4.loyalty_system.repository;

import com.kanapa4.loyalty_system.model.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Optional<Membership> findByUserIdAndProgramId(Long userId, Long programId);
    List<Membership> findByUserId(Long userId);
    List<Membership> findByProgramId(Long programId);
}
