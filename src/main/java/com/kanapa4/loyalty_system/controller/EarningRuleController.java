package com.kanapa4.loyalty_system.controller;

import com.kanapa4.loyalty_system.model.dto.CreateEarningRuleCommand;
import com.kanapa4.loyalty_system.model.dto.EarningRuleDto;
import com.kanapa4.loyalty_system.service.EarningRuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EarningRuleController {
    private final EarningRuleService earningRuleService;

    @PostMapping("/programs/{programId}/earning-rules")
    @ResponseStatus(HttpStatus.CREATED)
    public EarningRuleDto createEarningRule(@PathVariable Long programId, @Valid @RequestBody CreateEarningRuleCommand dto) {
        return earningRuleService.createEarningRule(programId, dto);
    }

    @GetMapping("/programs/{programId}/earning-rules")
    public List<EarningRuleDto> getEarningRulesByProgram(@PathVariable Long programId) {
        return earningRuleService.getEarningRulesByProgram(programId);
    }

    @GetMapping("/earning-rules/{ruleId}")
    public EarningRuleDto getEarningRuleById(@PathVariable Long ruleId) {
        return earningRuleService.getEarningRuleById(ruleId);
    }

    @PutMapping("/earning-rules/{ruleId}")
    public EarningRuleDto updateEarningRule(@PathVariable Long ruleId, @Valid @RequestBody CreateEarningRuleCommand dto) {
        return earningRuleService.updateEarningRule(ruleId, dto);
    }

    @DeleteMapping("/earning-rules/{ruleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEarningRule(@PathVariable Long ruleId) {
        earningRuleService.deleteEarningRule(ruleId);
    }
}
