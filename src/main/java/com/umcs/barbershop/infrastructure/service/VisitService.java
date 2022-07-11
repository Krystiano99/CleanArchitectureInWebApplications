package com.umcs.barbershop.infrastructure.service;

import com.umcs.barbershop.infrastructure.entity.VisitEntity;
import com.umcs.barbershop.infrastructure.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<VisitEntity> getVisits() {
        return visitRepository.findAll();
    }

    public void addNewVisit(VisitEntity visitEntity) {
        Optional<VisitEntity> studentOptional = visitRepository.findVisitById(visitEntity.getId());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        visitRepository.save(visitEntity);
    }

    public void deleteVisit(Long visitId) {
    }

    public void updateVisit(Long visitId, String name, String email) {
    }
}
