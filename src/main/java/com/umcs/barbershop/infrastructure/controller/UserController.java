package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.User;

import com.umcs.barbershop.domain.port.driven.UserServicePort;
import com.umcs.barbershop.infrastructure.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {
    private final UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping
    public List<User> getUsers() {
        return userServicePort.getUsers();
    }
    @GetMapping(path = "{userId}")
    public User getUserById(@PathVariable("userId") UUID userId) {
        return userServicePort.getUserById(userId);
    }
    @GetMapping(path = "/barber")
    public List<User> getBarbers() {
        return userServicePort.getBarbers();
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        return userServicePort.addUser(
                new User(null,
                        userDto.getFirstName(),
                        userDto.getLastName(),
                        userDto.getEmail(),
                        userDto.getPhoneNumber(),
                        userDto.getRole())
        );
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") UUID userId) {
        userServicePort.deleteUserById(userId);
    }

    @PatchMapping("{userId}")
    public User updateUser(@PathVariable UUID userId, @RequestBody UserDto userDto) {
        return userServicePort.updateUser(userId, new User(userId, userDto.getFirstName(), userDto.getLastName(), userDto.getPhoneNumber(), userDto.getEmail(), userDto.getRole()));
    }

}
