package com.umcs.barbershop.domain.port.driving;

import com.umcs.barbershop.domain.model.Visit;

import java.util.List;
import java.util.UUID;

public interface VisitRepositoryPort {
    List<Visit> findAll();
    Visit getVisitById(UUID id);
    Visit deleteVisitById(UUID id);
    Visit addVisit(Visit visit);
}
