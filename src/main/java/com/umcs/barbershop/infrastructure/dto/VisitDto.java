package com.umcs.barbershop.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Data
public class VisitDto {
    UUID id;
    UUID customerId;
    UUID barberId;
    UUID haircutId;
    Date visitDate;
}
