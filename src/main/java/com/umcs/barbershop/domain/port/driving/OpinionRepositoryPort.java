package com.umcs.barbershop.domain.port.driving;

import com.umcs.barbershop.domain.model.Opinion;

import java.util.List;
import java.util.UUID;

public interface OpinionRepositoryPort {
    List<Opinion> findAll();
    Opinion addOpinion(Opinion opinion);
    Opinion getOpinionById(UUID id);
    Opinion deleteOpinionById(UUID id);
}
