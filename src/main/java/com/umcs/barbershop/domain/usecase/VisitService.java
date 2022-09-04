package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.exception.*;
import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.driving.VisitRepositoryPort;

import java.util.*;

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

    public Visit getVisitById(UUID id) {
        return this.visitRepositoryPort.getVisitById(id);
    }

    public Visit deleteVisitById(UUID id) {
        return this.visitRepositoryPort.deleteVisitById(id);
    }

    private Map<String, User> validateVisitUsers(UUID customerId, UUID barberId){
        User customer = userService.getUserById(customerId);
        if(Objects.isNull(customer) || !customer.getRole().contains("customer")) {
            throw new UserNotFoundException("Customer not found.");
        }
        User barber = userService.getUserById(barberId);
        if(Objects.isNull(barber) || !barber.getRole().contains("barber")) {
            throw new UserNotFoundException("Barber not found.");
        }
        Map<String, User> users = new HashMap<>();
        users.put("customer", customer);
        users.put("barber", barber);
        return users;
    }

    public Visit scheduleVisit(UUID customerId, UUID barberId, UUID haircutId, Date visitDate) {
        Map<String, User> users = validateVisitUsers(customerId, barberId);

        Haircut haircut = haircutService.getHaircutById(haircutId);
        if(Objects.isNull(haircut)) {
            throw new HaircutNotFoundException("Haircut not found.");
        }

        return addVisit(new Visit(null, new Date(), visitDate, haircut, users.get("barber"), users.get("customer")));
    }

    public Visit cancelVisit(UUID visitId, UUID barberId, UUID customerId) {
        Visit visit = getVisitById(visitId);
        if(visit.getId() != visitId) {
            throw new VisitNotFoundException("Visit not found.");
        }

        Map<String, User> users = validateVisitUsers(customerId, barberId);

        if(!users.get("customer").getId().equals(customerId)) {
            throw new UserNotAssociatedException("Customer is not associated with Visit");
        }
        if(!users.get("barber").getId().equals(barberId)) {
            throw new UserNotAssociatedException("Barber is not associated with Visit");
        }

        return deleteVisitById(visitId);
    }
}
