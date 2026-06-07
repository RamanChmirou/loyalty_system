package com.kanapa4.loyalty_system.service;

import com.kanapa4.loyalty_system.exception.EarningRuleNotFoundException;
import com.kanapa4.loyalty_system.exception.ProgramNotFoundException;
import com.kanapa4.loyalty_system.mapper.EarningRuleMapper;
import com.kanapa4.loyalty_system.model.dto.CreateEarningRuleCommand;
import com.kanapa4.loyalty_system.model.dto.EarningRuleDto;
import com.kanapa4.loyalty_system.model.entity.EarningRule;
import com.kanapa4.loyalty_system.model.entity.LoyaltyProgram;
import com.kanapa4.loyalty_system.repository.EarningRuleRepository;
import com.kanapa4.loyalty_system.repository.LoyaltyProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EarningRuleService {
    private final EarningRuleRepository earningRuleRepository;
    private final LoyaltyProgramRepository loyaltyProgramRepository;
    private final EarningRuleMapper earningRuleMapper;

    public EarningRuleDto createEarningRule(Long programId, CreateEarningRuleCommand dto) {
        LoyaltyProgram program = loyaltyProgramRepository.findById(programId)
                .orElseThrow(() -> new ProgramNotFoundException("Program not found"));

        EarningRule rule = earningRuleMapper.toEntity(dto);
        rule.setProgram(program);

        return earningRuleMapper.toDto(earningRuleRepository.save(rule));
    }

    public List<EarningRuleDto> getEarningRulesByProgram(Long programId) {
        if (!loyaltyProgramRepository.existsById(programId)) {
            throw new ProgramNotFoundException("Program not found");
        }

        return earningRuleRepository.findByProgramId(programId).stream()
                .map(earningRuleMapper::toDto)
                .toList();
    }

    public EarningRuleDto getEarningRuleById(Long ruleId) {
        return earningRuleMapper.toDto(earningRuleRepository.findById(ruleId)
                .orElseThrow(() -> new EarningRuleNotFoundException("Earning rule not found")));
    }

    @Transactional
    public EarningRuleDto updateEarningRule(Long ruleId, CreateEarningRuleCommand dto) {
        EarningRule rule = earningRuleRepository.findById(ruleId)
                .orElseThrow(() -> new EarningRuleNotFoundException("Earning rule not found"));

        rule.setName(dto.getName());
        rule.setEventType(dto.getEventType());
        rule.setPointsAmount(dto.getPointsAmount());
        rule.setActive(dto.isActive());

        if (rule.getValidityPeriod() != null) {
            rule.getValidityPeriod().setStartDate(dto.getStartDate());
            rule.getValidityPeriod().setEndDate(dto.getEndDate());
        }

        return earningRuleMapper.toDto(earningRuleRepository.save(rule));
    }

    @Transactional
    public void deleteEarningRule(Long ruleId) {
        if (!earningRuleRepository.existsById(ruleId)) {
            throw new EarningRuleNotFoundException("Earning rule not found");
        }
        earningRuleRepository.deleteById(ruleId);
    }
}
