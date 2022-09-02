package com.umcs.barbershop.infrastructure.dto;

import com.umcs.barbershop.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class OpinionDto {
    UUID customerId;
    String comment;
    int rate;
}
