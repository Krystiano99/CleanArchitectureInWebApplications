package com.umcs.barbershop.infrastructure.repository;

import com.umcs.barbershop.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
    Optional<UserEntity> findUserByEmail(String email);
}
