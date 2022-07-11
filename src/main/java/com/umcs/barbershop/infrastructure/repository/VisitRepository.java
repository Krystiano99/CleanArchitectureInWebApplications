package com.umcs.barbershop.infrastructure.repository;

import com.umcs.barbershop.infrastructure.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    @Query("SELECT v FROM VisitEntity v WHERE v.id = ?1")
    Optional<VisitEntity> findVisitById(Long visit);
}
