package com.umcs.barbershop.infrastructure.adapter;

import com.umcs.barbershop.domain.model.Service;
import com.umcs.barbershop.domain.port.service.ServiceServicePort;
import com.umcs.barbershop.domain.usecase.ServiceService;

import java.util.List;
import java.util.UUID;

public class ServiceServiceAdapter implements ServiceServicePort {
    private final ServiceService  serviceService;

    public ServiceServiceAdapter(ServiceService userService) {
        this.serviceService = userService;
    }

    @Override
    public List<Service> getServices() {
        return serviceService.getServices();
    }

    @Override
    public Service addService(Service service) {
        return serviceService.addService(service);
    }

    @Override
    public Service getServiceById(UUID id) {
        return serviceService.getServiceById(id);
    }

    @Override
    public Service updateService(UUID id, Service service) {
        return serviceService.updateService(id, service);
    }

    @Override
    public Service deleteServiceById(UUID id) {
        return serviceService.deleteServiceById(id);
    }

}
