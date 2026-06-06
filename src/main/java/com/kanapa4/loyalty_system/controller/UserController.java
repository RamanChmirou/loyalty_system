package com.kanapa4.loyalty_system.controller;

import com.kanapa4.loyalty_system.model.dto.CreateUserCommand;
import com.kanapa4.loyalty_system.model.dto.UserDto;
import com.kanapa4.loyalty_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody CreateUserCommand command) {
        return userService.createUser(command);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @Valid @RequestBody CreateUserCommand command) {
        return userService.updateUser(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{userId}/programs/{programId}")
    @ResponseStatus(HttpStatus.OK)
    public void assignUserToProgram(@PathVariable Long userId, @PathVariable Long programId) {
        userService.assignUserToProgram(userId, programId);
    }

    @DeleteMapping("/{userId}/programs/{programId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUserFromProgram(@PathVariable Long userId, @PathVariable Long programId) {
        userService.removeUserFromProgram(userId, programId);
    }
}
