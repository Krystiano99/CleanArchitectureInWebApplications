package com.umcs.barbershop.domain.port.service;

import com.umcs.barbershop.domain.model.Service;

import java.util.List;
import java.util.UUID;

public interface ServiceServicePort {
    List<Service> getServices();
    Service getServiceById(UUID id);
    Service addService(Service service);
    Service updateService(UUID id, Service service);
    Service deleteServiceById(UUID id);
}
