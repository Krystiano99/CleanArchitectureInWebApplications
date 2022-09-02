package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.exception.OpinionDuplicatedException;
import com.umcs.barbershop.domain.exception.UserNotFoundException;
import com.umcs.barbershop.domain.model.Opinion;
import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.port.driving.OpinionRepositoryPort;
import com.umcs.barbershop.domain.exception.OpinionIllegalValueException;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OpinionService {
    private final OpinionRepositoryPort opinionRepositoryPort;
    private final UserService userService;
    public OpinionService(OpinionRepositoryPort opinionRepositoryPort, UserService userService) {
        this.opinionRepositoryPort = opinionRepositoryPort;
        this.userService = userService;
    }

    public List<Opinion> getOpinions(){return this.opinionRepositoryPort.findAll();}

    public Opinion getOpinionById(UUID id) {
        return this.opinionRepositoryPort.getOpinionById(id);
    }


    public Opinion deleteOpinionById(UUID id) {
        return this.opinionRepositoryPort.deleteOpinionById(id);
    }
    public Opinion addOpinion(Opinion opinion) {
        return opinionRepositoryPort.addOpinion(opinion);
    }

    public Opinion leaveOpinion(UUID customerId, int rate, String comment){
        User customer = userService.getUserById(customerId);
        int minCommentLength = 5;
        int minRate = 1;
        int maxRate = 5;

        if(Objects.isNull(customer) || !customer.getRole().contains("customer")) {
            throw new UserNotFoundException("Customer not found.");
        }
        if(getOpinions().stream().anyMatch(opinion -> opinion.getCustomer().getId().equals(customerId))){
            throw new OpinionDuplicatedException("Customer can only give one opinion.");
        }
        if(rate < minRate || rate > maxRate){
            throw new OpinionIllegalValueException(String.format("The rating must be an integer from %s to %d", minRate, maxRate));
        }
        if(comment.length() < minCommentLength){
            throw new OpinionIllegalValueException(String.format("Comment must be at least %s characters long.", minCommentLength));
        }
        return addOpinion(new Opinion(null, customer, rate, comment));
    }

    public double getAverageRating(){
        return getOpinions().stream()
                .mapToInt(opinion -> opinion.getRate())
                .average()
                .orElse(0);
    }

}
