package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.port.repository.UserRepositoryPort;
import com.umcs.barbershop.infrastructure.persistence.entity.UserEntity;
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
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getLogin(),
                        userEntity.getPassword(),
                        userEntity.getEmail(),
                        userEntity.getPhoneNumber(),
                        userEntity.getRole()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public User addUser(User user) {
        UserEntity result = userRepository.save(new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole()
        ));
        return new User(result.getId(), result.getFirstName(), user.getLastName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getRole());
    }

    @Override
    public User getUserById(UUID id) {
        Optional<UserEntity> result = userRepository.findById(id);

        if(result.isEmpty()) {
            return null;
        }

        return new User(result.get().getId(), result.get().getFirstName(), result.get().getLastName(), result.get().getLogin(),
                result.get().getPassword(), result.get().getEmail(), result.get().getPhoneNumber(), result.get().getRole());
    }

    @Override
    public User updateUser(UUID id, User user) {
        UserEntity userTuUpdate = userRepository.findById(id).get();

        userTuUpdate.setFirstName(user.getFirstName());
        userTuUpdate.setLastName(user.getLastName());
        userTuUpdate.setLogin(user.getLogin());
        userTuUpdate.setPassword(user.getPassword());

        UserEntity result = userRepository.save(userTuUpdate);

        return new User(result.getId(), result.getFirstName(), result.getLastName(), result.getLogin(), result.getPassword(), result.getEmail(),
                result.getPhoneNumber(), result.getRole());
    }
    @Override
    public User deleteUserById(UUID id) {
        UserEntity userToDelete = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return new User(userToDelete.getId(), userToDelete.getFirstName(), userToDelete.getLastName(), userToDelete.getLogin(),
                userToDelete.getPassword(), userToDelete.getEmail(), userToDelete.getPhoneNumber(), userToDelete.getRole());
    }

}