package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.model.Service;
import com.umcs.barbershop.domain.port.repository.ServiceRepositoryPort;

import com.umcs.barbershop.infrastructure.persistence.entity.ServiceEntity;
import com.umcs.barbershop.infrastructure.persistence.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ServiceInDatabaseAdapter implements ServiceRepositoryPort {

    private final ServiceRepository serviceRepository;

    public ServiceInDatabaseAdapter(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll().stream()
                .map(serviceEntity -> new Service(
                        serviceEntity.getId(),
                        serviceEntity.getName(),
                        serviceEntity.getPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Service addService(Service service) {
        ServiceEntity result = serviceRepository.save(new ServiceEntity(
                service.getId(),
                service.getName(),
                service.getPrice()
        ));
        return new Service(result.getId(), result.getName(), result.getPrice());
    }

    public Service getServiceById(UUID id) {
        Optional<ServiceEntity> result = serviceRepository.findById(id);

        if(result.isEmpty()) {
            return null;
        }

        return new Service(result.get().getId(), result.get().getName(), result.get().getPrice());
    }

    @Override
    public Service updateService(UUID id, Service service) {
        ServiceEntity serviceToUpdate = serviceRepository.findById(id).get();

        serviceToUpdate.setName(service.getName());
        serviceToUpdate.setPrice(service.getPrice());

        ServiceEntity result = serviceRepository.save(serviceToUpdate);

        return new Service(result.getId(), result.getName(), result.getPrice());
    }
    @Override
    public Service deleteServiceById(UUID id) {
        ServiceEntity serviceToDelete = serviceRepository.findById(id).get();
        serviceRepository.deleteById(id);
        return new Service(serviceToDelete.getId(), serviceToDelete.getName(), serviceToDelete.getPrice());
    }

}