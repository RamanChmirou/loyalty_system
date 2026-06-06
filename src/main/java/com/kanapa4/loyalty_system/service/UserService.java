package com.kanapa4.loyalty_system.service;

import com.kanapa4.loyalty_system.exception.*;
import com.kanapa4.loyalty_system.mapper.UserMapper;
import com.kanapa4.loyalty_system.model.dto.CreateUserCommand;
import com.kanapa4.loyalty_system.model.dto.UserDto;
import com.kanapa4.loyalty_system.model.entity.LoyaltyProgram;
import com.kanapa4.loyalty_system.model.entity.Membership;
import com.kanapa4.loyalty_system.model.entity.User;
import com.kanapa4.loyalty_system.repository.LoyaltyProgramRepository;
import com.kanapa4.loyalty_system.repository.MembershipRepository;
import com.kanapa4.loyalty_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final LoyaltyProgramRepository loyaltyProgramRepository;
    private final MembershipRepository membershipRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDto createUser(CreateUserCommand command) {
        if (userRepository.findByEmail(command.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User user = userMapper.toEntity(command);
        User savedUser = userRepository.save(user);

        if (command.getInitialProgramId() != null) {
            LoyaltyProgram program = loyaltyProgramRepository.findById(command.getInitialProgramId())
                    .orElseThrow(() -> new ProgramNotFoundException("Program not found"));

            Membership membership = Membership.builder()
                    .user(savedUser)
                    .program(program)
                    .build();

            membershipRepository.save(membership);
        }

        return userMapper.toDto(userRepository.findById(savedUser.getId()).orElseThrow());
    }

    @Transactional(readOnly = true)
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDto updateUser(Long id, CreateUserCommand command) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!user.getEmail().equals(command.getEmail()) && userRepository.findByEmail(command.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        user.setFirstName(command.getFirstName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());

        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void assignUserToProgram(Long userId, Long programId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        LoyaltyProgram program = loyaltyProgramRepository.findById(programId)
                .orElseThrow(() -> new ProgramNotFoundException("Program not found"));

        if (membershipRepository.findByUserIdAndProgramId(userId, programId).isPresent()) {
            throw new MembershipAlreadyExistsException("User is already a member of this program");
        }

        Membership membership = Membership.builder()
                .user(user)
                .program(program)
                .build();

        membershipRepository.save(membership);
    }

    @Transactional
    public void removeUserFromProgram(Long userId, Long programId) {
        Membership membership = membershipRepository.findByUserIdAndProgramId(userId, programId)
                .orElseThrow(() -> new MembershipNotFoundException("Membership not found"));

        membershipRepository.delete(membership);
    }
}
