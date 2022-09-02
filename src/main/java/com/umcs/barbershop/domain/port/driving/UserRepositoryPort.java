package com.umcs.barbershop.domain.port.driving;

import com.umcs.barbershop.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryPort {
    List<User> findAll();
    User addUser(User user);
    User getUserById(UUID id);
    User updateUser(UUID id, User user);
    User deleteUserById(UUID id);

}
