package com.umcs.barbershop.domain.port.service;

import com.umcs.barbershop.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserServicePort {
    List<User> getUsers();
    User getUserById(UUID id);
    User addUser(User user);
    User updateUser(UUID id, User user);
    User deleteUserById(UUID id);
}
