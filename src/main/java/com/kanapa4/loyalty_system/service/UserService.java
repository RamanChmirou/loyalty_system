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

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final LoyaltyProgramRepository loyaltyProgramRepository;
    private final MembershipRepository membershipRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDto createUser(CreateUserCommand dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);

        if (dto.getInitialProgramId() != null) {
            LoyaltyProgram program = loyaltyProgramRepository.findById(dto.getInitialProgramId())
                    .orElseThrow(() -> new ProgramNotFoundException("Program not found"));

            Membership membership = Membership.builder()
                    .user(savedUser)
                    .program(program)
                    .build();

            membershipRepository.save(membership);
        }

        return userMapper.toDto(userRepository.findById(savedUser.getId()).orElseThrow());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Transactional
    public UserDto updateUser(Long id, CreateUserCommand dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!user.getEmail().equals(dto.getEmail()) && userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());

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
