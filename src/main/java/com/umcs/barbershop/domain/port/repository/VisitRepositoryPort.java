package com.umcs.barbershop.domain.port.repository;

import com.umcs.barbershop.domain.model.Visit;

import java.util.List;
import java.util.UUID;

public interface VisitRepositoryPort {
    List<Visit> findAll();
    Visit addVisit(Visit visit);
    Visit getVisitById(UUID id);
    Visit deleteVisitById(UUID id);
}
