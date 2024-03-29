package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.port.driving.UserRepositoryPort;
import com.umcs.barbershop.infrastructure.persistence.entity.AppUserEntity;
import com.umcs.barbershop.infrastructure.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserInDatabaseAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;

    public UserInDatabaseAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(barbershopUserEntity -> new User(
                        barbershopUserEntity.getId(),
                        barbershopUserEntity.getFirstName(),
                        barbershopUserEntity.getLastName(),
                        barbershopUserEntity.getEmail(),
                        barbershopUserEntity.getPhoneNumber(),
                        barbershopUserEntity.getRole()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public User addUser(User user) {
        AppUserEntity result = userRepository.save(new AppUserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole()
        ));
        return new User(result.getId(), result.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getRole());
    }

    @Override
    public User getUserById(UUID id) {
        Optional<AppUserEntity> result = userRepository.findById(id);

        if(result.isEmpty()) {
            return null;
        }

        return new User(result.get().getId(), result.get().getFirstName(), result.get().getLastName(), result.get().getEmail(), result.get().getPhoneNumber(), result.get().getRole());
    }

    @Override
    public User updateUser(UUID id, User user) {
        AppUserEntity userToUpdate = userRepository.findById(id).get();

        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userToUpdate.setRole(user.getRole());
        AppUserEntity result = userRepository.save(userToUpdate);

        return new User(result.getId(), result.getFirstName(), result.getLastName(), result.getEmail(),
                result.getPhoneNumber(), result.getRole());
    }
    @Override
    public User deleteUserById(UUID id) {
        AppUserEntity userToDelete = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return new User(userToDelete.getId(), userToDelete.getFirstName(), userToDelete.getLastName(), userToDelete.getEmail(), userToDelete.getPhoneNumber(), userToDelete.getRole());
    }

}