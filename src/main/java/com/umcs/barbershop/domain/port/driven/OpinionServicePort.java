package com.umcs.barbershop.domain.port.driven;

import com.umcs.barbershop.domain.model.Opinion;

import java.util.List;
import java.util.UUID;

public interface OpinionServicePort {
    List<Opinion> getOpinions();
    Opinion leaveOpinion(UUID customerId, int rate, String comment);
    Opinion deleteOpinionById(UUID id);
    double getAverageRating();
}
