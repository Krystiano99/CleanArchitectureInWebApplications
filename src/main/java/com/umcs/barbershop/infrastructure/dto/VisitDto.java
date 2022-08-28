package com.umcs.barbershop.infrastructure.dto;

import com.umcs.barbershop.domain.model.Service;
import com.umcs.barbershop.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
public class VisitDto {
    Date createdDate;
    LocalDate visitDate;
    Service service;
    User barber;
    User customer;

}
