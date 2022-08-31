package com.umcs.barbershop.infrastructure.persistence.repository;


import com.umcs.barbershop.infrastructure.persistence.entity.HaircutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HaircutRepository extends JpaRepository<HaircutEntity, UUID> {

}
