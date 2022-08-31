package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.exception.BarberNotFoundException;
import com.umcs.barbershop.domain.exception.CustomerNotFoundException;
import com.umcs.barbershop.domain.exception.ServiceNotFoundException;
import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.driving.VisitRepositoryPort;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class VisitService {
    private final VisitRepositoryPort visitRepositoryPort;
    private final HaircutService haircutService;
    private final UserService userService;


    public VisitService(VisitRepositoryPort visitRepositoryPort, HaircutService haircutService, UserService userService) {
        this.visitRepositoryPort = visitRepositoryPort;
        this.haircutService = haircutService;
        this.userService = userService;
    }

    public List<Visit> getVisits() {
        return this.visitRepositoryPort.findAll();
    }

    public Visit addVisit(Visit visit) {
        return visitRepositoryPort.addVisit(visit);
    }

    public Visit scheduleVisit(UUID customerId, UUID barberId, UUID serviceId, Date visitDate){
        User customer = userService.getUserById(customerId);
        if(Objects.isNull(customer)) {
            throw new CustomerNotFoundException("Customer not found.");
        }
        User barber = userService.getUserById(barberId);
        if(Objects.isNull(barber)) {
            throw new BarberNotFoundException("Barber not found.");
        }
        Haircut haircut = haircutService.getHaircutById(serviceId);
        if(Objects.isNull(haircut)) {
            throw new ServiceNotFoundException("Service not found.");
        }

        return addVisit(new Visit(null, new Date(), visitDate, haircut, barber, customer ));
    }

    public Visit getVisitById(UUID id) {
        return this.visitRepositoryPort.getVisitById(id);
    }

    public Visit getVisitByUserId(UUID id) {
        return this.visitRepositoryPort.getVisitByUserId(id);
    }


    public Visit deleteVisitById(UUID id) {
        return this.visitRepositoryPort.deleteVisitById(id);
    }
}
