package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.User;

import com.umcs.barbershop.domain.port.service.UserServicePort;
import com.umcs.barbershop.infrastructure.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServicePort userServicePort;

//    @Autowired
    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping
    public List<User> getUsers() {
        return userServicePort.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        return userServicePort.addUser(
                new User(null,
                        userDto.getFirstName(),
                        userDto.getLastName(),
                        userDto.getLogin(),
                        userDto.getPassword(),
                        userDto.getEmail(),
                        userDto.getPhoneNumber(),
                        userDto.getRole())
        );
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") UUID userId) {
        userServicePort.deleteUserById(userId);
    }

//    @PutMapping(path = "{userId}")
//    public void updateUser(
//            @PathVariable("userId") Long userId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email) {
//        userServicePort.updateUser(userId, name, email);
//    }

}
