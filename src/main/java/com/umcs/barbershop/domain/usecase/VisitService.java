package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.repository.VisitRepositoryPort;

import java.util.List;
import java.util.UUID;

public class VisitService {
    private final VisitRepositoryPort visitRepositoryPort;
    private final ServiceService serviceService;
    private final UserService barberService;
    private final UserService customerService;

    public VisitService(VisitRepositoryPort visitRepositoryPort, ServiceService serviceService, UserService barberService, UserService customerService) {
        this.visitRepositoryPort = visitRepositoryPort;
        this.serviceService = serviceService;
        this.barberService = barberService;
        this.customerService = customerService;
    }

    public List<Visit> getVisits() {
        return this.visitRepositoryPort.findAll();
    }

    public Visit addVisit(Visit visit) {
        return visitRepositoryPort.addVisit(visit);
    }

    public Visit getVisitById(UUID id) {
        return this.visitRepositoryPort.getVisitById(id);
    }


    public Visit deleteVisitById(UUID id) {
        return this.visitRepositoryPort.deleteVisitById(id);
    }
}
