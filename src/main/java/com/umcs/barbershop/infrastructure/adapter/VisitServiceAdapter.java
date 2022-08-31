package com.umcs.barbershop.infrastructure.adapter;

import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.driven.VisitServicePort;
import com.umcs.barbershop.domain.usecase.VisitService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VisitServiceAdapter implements VisitServicePort {
    private final VisitService visitService;

    public VisitServiceAdapter(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public List<Visit> getVisits() {
        return visitService.getVisits();
    }

    @Override
    public Visit getVisitById(UUID id) {
        return visitService.getVisitById(id);
    }

    @Override
    public Visit addVisit(Visit visit) {
        return visitService.addVisit(visit);
    }


    @Override
    public Visit deleteVisitById(UUID id) {
        return visitService.deleteVisitById(id);
    }

    @Override
    public Visit getVisitByUserId(UUID id) {
        return visitService.getVisitByUserId(id);
    }

    @Override
    public Visit scheduleVisit(UUID customerId, UUID barberId, UUID serviceId, Date visitDate) {
        return visitService.scheduleVisit(customerId, barberId, serviceId, visitDate);
    }

}
