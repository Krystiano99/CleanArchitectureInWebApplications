package com.umcs.barbershop.infrastructure.dto;

import com.umcs.barbershop.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OpinionDto {
    User customer;
    String comment;
    int assessment;
}
