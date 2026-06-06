package com.kanapa4.loyalty_system.mapper;

import com.kanapa4.loyalty_system.model.dto.CreateUserCommand;
import com.kanapa4.loyalty_system.model.dto.UserDto;
import com.kanapa4.loyalty_system.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MembershipMapper.class})
public interface UserMapper {
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "memberships", ignore = true)
    User toEntity(CreateUserCommand command);
}
