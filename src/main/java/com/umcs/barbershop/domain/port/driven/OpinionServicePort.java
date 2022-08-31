package com.umcs.barbershop.domain.port.driven;

import com.umcs.barbershop.domain.model.Opinion;

import java.util.List;
import java.util.UUID;

public interface OpinionServicePort {
    List<Opinion> getOpinions();
    Opinion getOpinionById(UUID id);
    Opinion addOpinion(Opinion opinion);
    Opinion deleteOpinionById(UUID id);
}
