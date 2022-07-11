package com.umcs.barbershop.infrastructure.service;

import com.umcs.barbershop.infrastructure.entity.UserEntity;
import com.umcs.barbershop.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(UserEntity userEntity) {
        Optional<UserEntity> userOptional = userRepository.findUserByEmail(userEntity.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(userEntity);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }
    @Transactional
    public void updateUser(Long userId, String firstName, String email) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(userEntity.getFirstName(), firstName)) {
            userEntity.setFirstName(firstName);
        }

        if (email != null && email.length() > 0 && !Objects.equals(userEntity.getEmail(), email)) {
            Optional<UserEntity> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            userEntity.setEmail(email);
        }
    }
}
