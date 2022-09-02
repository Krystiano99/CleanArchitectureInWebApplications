package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.driving.VisitRepositoryPort;
import com.umcs.barbershop.infrastructure.persistence.entity.HaircutEntity;
import com.umcs.barbershop.infrastructure.persistence.entity.UserEntity;
import com.umcs.barbershop.infrastructure.persistence.entity.VisitEntity;
import com.umcs.barbershop.infrastructure.persistence.repository.VisitRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class VisitInDatabaseAdapter implements VisitRepositoryPort {
    private final VisitRepository visitRepository;

    public VisitInDatabaseAdapter(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll().stream()
                .map(visitEntity -> new Visit(
                        visitEntity.getId(),
                        visitEntity.getCreatedDate(),
                        visitEntity.getVisitDate(),
                        serviceEntityToService(visitEntity.getHaircutEntity()),
                        customerEntityToUser(visitEntity.getCustomerEntity()),
                        barberEntityToUser(visitEntity.getUserEntity())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Visit addVisit(Visit visit) {
        VisitEntity result = visitRepository.save(new VisitEntity(
                visit.getId(),
                visit.getCreatedDate(),
                visit.getVisitDate(),
                serviceToServiceEntity(visit.getHaircut()),
                customerToEntityUser(visit.getCustomer()),
                barberToEntityUser(visit.getBarber())
        ));
        return new Visit(result.getId(),
                result.getCreatedDate(),
                result.getVisitDate(),
                serviceEntityToService(result.getHaircutEntity()),
                customerEntityToUser(result.getCustomerEntity()),
                barberEntityToUser(result.getUserEntity())
        );
    }

    private UserEntity barberToEntityUser(User barber) {
        return new UserEntity(
                barber.getId(),
                barber.getFirstName(),
                barber.getLastName(),
                barber.getPhoneNumber(),
                barber.getEmail(),
                barber.getRole()
        );
    }

    private UserEntity customerToEntityUser(User customer) {
        return new UserEntity(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getRole()
        );
    }

    private User customerEntityToUser(UserEntity customerEntity) {
        return new User(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getPhoneNumber(),
                customerEntity.getEmail(),
                customerEntity.getRole()
        );
    }

    private User barberEntityToUser(UserEntity barberEntity) {
        return new User(
                barberEntity.getId(),
                barberEntity.getFirstName(),
                barberEntity.getLastName(),
                barberEntity.getPhoneNumber(),
                barberEntity.getEmail(),
                barberEntity.getRole()
        );
    }

    public Visit getVisitById(UUID id) {
       Optional<VisitEntity> result = visitRepository.findById(id);

        if (result.isEmpty()) {
            return null;
        }

        return new Visit(result.get().getId(),
                result.get().getCreatedDate(),
                result.get().getVisitDate(),
                serviceEntityToService(result.get().getHaircutEntity()),
                customerEntityToUser(result.get().getCustomerEntity()),
                barberEntityToUser(result.get().getUserEntity())
                );
    }

    @Override
    public Visit deleteVisitById(UUID id) {
        VisitEntity visitToDelete = visitRepository.findById(id).get();
        visitRepository.deleteById(id);
        return new Visit(visitToDelete.getId(),
                visitToDelete.getCreatedDate(),
                visitToDelete.getVisitDate(),
                serviceEntityToService(visitToDelete.getHaircutEntity()),
                customerEntityToUser(visitToDelete.getCustomerEntity()),
                barberEntityToUser(visitToDelete.getUserEntity())
                );
    }

    private Haircut serviceEntityToService(HaircutEntity haircutEntity) {
        return new Haircut(
                haircutEntity.getId(),
                haircutEntity.getName(),
                haircutEntity.getPrice()
        );
    }

    private HaircutEntity serviceToServiceEntity(Haircut haircut) {
        return new HaircutEntity(
                haircut.getId(),
                haircut.getName(),
                haircut.getPrice()
        );
    }

}