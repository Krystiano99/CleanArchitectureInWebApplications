package com.umcs.barbershop.infrastructure.adapter;

import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.service.VisitServicePort;
import com.umcs.barbershop.domain.usecase.VisitService;

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
        return null;
    }

    @Override
    public Visit addVisit(Visit visit) {
        return visitService.addVisit(visit);
    }

//    @Override
//    public Visit updateVisit(UUID id, Visit visit) {
//        return null;
//    }

    @Override
    public Visit deleteVisitById(UUID id) {
        return null;
    }

    @Override
    public Visit getVisitByUserId(UUID id) {
        return null;
    }

}
