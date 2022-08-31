package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.port.driving.UserRepositoryPort;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public List<User> getUsers() {
        return this.userRepositoryPort.findAll();
    }

    public List<User> getUsersByRole(String role) {
        return getUsers()
                .stream()
                .filter(user->user.getRole().contains(role))
                .collect(Collectors.toList());
    }

    public User addUser(User user) {
        return userRepositoryPort.addUser(user);
    }

    public User getUserById(UUID id) {
        return this.userRepositoryPort.getUserById(id);
    }

    public User updateUser(UUID id, User user) {
        return this.userRepositoryPort.updateUser(id, user);
    }

    public User deleteUserById(UUID id) {
        return this.userRepositoryPort.deleteUserById(id);
    }
}
