package com.umcs.barbershop.domain.port.repository;

import com.umcs.barbershop.domain.model.Service;

import java.util.List;
import java.util.UUID;

public interface ServiceRepositoryPort {
    List<Service> findAll();
    Service addService(Service service);
    Service getServiceById(UUID id);
    Service updateService(UUID id, Service service);
    Service deleteServiceById(UUID id);
}
