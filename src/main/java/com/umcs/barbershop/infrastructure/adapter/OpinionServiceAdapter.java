package com.umcs.barbershop.infrastructure.adapter;

import com.umcs.barbershop.domain.model.Opinion;
import com.umcs.barbershop.domain.port.driven.OpinionServicePort;
import com.umcs.barbershop.domain.usecase.OpinionService;

import java.util.List;
import java.util.UUID;


public class OpinionServiceAdapter implements OpinionServicePort {
    private final OpinionService opinionService;

    public OpinionServiceAdapter(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @Override
    public List<Opinion> getOpinions() {
        return opinionService.getOpinions();
    }

    @Override
    public Opinion leaveOpinion(UUID customerId, int rate, String comment) {
        return opinionService.leaveOpinion(customerId, rate, comment);
    }

    @Override
    public Opinion deleteOpinionById(UUID id) {
        return opinionService.deleteOpinionById(id);
    }

    @Override
    public double getAverageRating(){return opinionService.getAverageRating();}

}
