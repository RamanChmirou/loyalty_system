package com.kanapa4.loyalty_system.mapper;

import com.kanapa4.loyalty_system.model.dto.MembershipDto;
import com.kanapa4.loyalty_system.model.entity.Membership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipMapper {

    @Mapping(source = "program.id", target = "programId")
    @Mapping(source = "program.name", target = "programName")
    MembershipDto toDto(Membership membership);
}
