package com.umcs.barbershop.infrastructure.persistence.repository;

import com.umcs.barbershop.infrastructure.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, UUID> {
//    Optional<VisitEntity> findByUserEntity_Id(UUID id);
}
