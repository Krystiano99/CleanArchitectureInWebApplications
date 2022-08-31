package com.umcs.barbershop.infrastructure.dto;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;

@AllArgsConstructor
@Data
public class VisitDto {
    Date createdDate;
    Date visitDate;
    Haircut haircut;
    User barber;
    User customer;

}
