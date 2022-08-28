package com.umcs.barbershop.infrastructure.persistence.repository;


import com.umcs.barbershop.domain.model.Service;
import com.umcs.barbershop.infrastructure.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, UUID> {

}
