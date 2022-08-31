package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.model.Opinion;
import com.umcs.barbershop.domain.port.driving.OpinionRepositoryPort;

import java.util.List;
import java.util.UUID;

public class OpinionService {
    private final OpinionRepositoryPort opinionRepositoryPort;

    public OpinionService(OpinionRepositoryPort opinionRepositoryPort) {
        this.opinionRepositoryPort = opinionRepositoryPort;
    }

    public List<Opinion> getOpinions(){return this.opinionRepositoryPort.findAll();}

    public Opinion addOpinion(Opinion opinion) {
        return opinionRepositoryPort.addOpinion(opinion);
    }

    public Opinion getOpinionById(UUID id) {
        return this.opinionRepositoryPort.getOpinionById(id);
    }


    public Opinion deleteOpinionById(UUID id) {
        return this.opinionRepositoryPort.deleteOpinionById(id);
    }
}
