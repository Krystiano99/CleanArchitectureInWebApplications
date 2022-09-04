package com.umcs.barbershop.infrastructure.persistence.repository;

import com.umcs.barbershop.infrastructure.persistence.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<AppUserEntity, UUID> {
}
