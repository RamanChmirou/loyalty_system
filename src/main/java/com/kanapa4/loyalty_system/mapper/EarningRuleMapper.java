package com.kanapa4.loyalty_system.mapper;

import com.kanapa4.loyalty_system.model.dto.CreateEarningRuleCommand;
import com.kanapa4.loyalty_system.model.dto.EarningRuleDto;
import com.kanapa4.loyalty_system.model.entity.EarningRule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EarningRuleMapper {

    @Mapping(source = "validityPeriod.startDate", target = "startDate")
    @Mapping(source = "validityPeriod.endDate", target = "endDate")
    EarningRuleDto toDto(EarningRule rule);

    @Mapping(source = "startDate", target = "validityPeriod.startDate")
    @Mapping(source = "endDate", target = "validityPeriod.endDate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "program", ignore = true)
    EarningRule toEntity(CreateEarningRuleCommand command);
}
