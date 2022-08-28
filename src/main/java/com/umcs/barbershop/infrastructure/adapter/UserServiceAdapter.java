package com.umcs.barbershop.infrastructure.adapter;

import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.port.service.UserServicePort;
import com.umcs.barbershop.domain.usecase.UserService;


import java.util.List;
import java.util.UUID;

public class UserServiceAdapter implements UserServicePort {
    private final UserService userService;

    public UserServiceAdapter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Override
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @Override
    public User getUserById(UUID id) {
        return userService.getUserById(id);
    }

    @Override
    public User updateUser(UUID id, User user) {
        return userService.updateUser(id, user);
    }

    @Override
    public User deleteUserById(UUID id) {
        return userService.deleteUserById(id);
    }
}
