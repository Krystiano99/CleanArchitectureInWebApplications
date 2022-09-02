package com.umcs.barbershop.domain.port.driven;

import com.umcs.barbershop.domain.model.Visit;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface VisitServicePort {
    List<Visit> getVisits();
    Visit cancelVisit(UUID visitId, UUID customerId, UUID barberId);
    Visit scheduleVisit(UUID customerId, UUID barberId, UUID haircutId, Date visitDate);
}
