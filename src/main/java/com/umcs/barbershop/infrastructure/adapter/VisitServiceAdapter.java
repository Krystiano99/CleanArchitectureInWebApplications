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
    public Visit cancelVisit(UUID visitId, UUID customerId, UUID barberId) {
        return visitService.cancelVisit(visitId, customerId, barberId);
    }

    @Override
    public Visit scheduleVisit(UUID customerId, UUID barberId, UUID haircutId, Date visitDate) {
        return visitService.scheduleVisit(customerId, barberId, haircutId, visitDate);
    }

}
