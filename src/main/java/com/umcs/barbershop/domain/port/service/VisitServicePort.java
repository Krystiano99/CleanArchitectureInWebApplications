package com.umcs.barbershop.domain.port.service;

import com.umcs.barbershop.domain.model.Visit;

import java.util.List;
import java.util.UUID;

public interface VisitServicePort {
    List<Visit> getVisits();
    Visit getVisitById(UUID id);
    Visit addVisit(Visit visit);
    Visit deleteVisitById(UUID id);

    Visit getVisitByUserId(UUID id);
}
