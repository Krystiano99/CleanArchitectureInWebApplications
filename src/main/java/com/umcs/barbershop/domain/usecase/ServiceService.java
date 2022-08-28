package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.model.Service;
import com.umcs.barbershop.domain.port.repository.ServiceRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ServiceService {
    private final ServiceRepositoryPort serviceRepositoryPort;

    public ServiceService(ServiceRepositoryPort serviceRepositoryPort) {
        this.serviceRepositoryPort = serviceRepositoryPort;
    }

    public List<Service> getServices() {
        return this.serviceRepositoryPort.findAll();
    }

    public Service addService(Service service) {
        return serviceRepositoryPort.addService(service);
    }

    public Service getServiceById(UUID id) {
        return this.serviceRepositoryPort.getServiceById(id);
    }

    public Service updateService(UUID id, Service service) {
        return this.serviceRepositoryPort.updateService(id, service);
    }

    public Service deleteServiceById(UUID id) {
        return this.serviceRepositoryPort.deleteServiceById(id);
    }
}
