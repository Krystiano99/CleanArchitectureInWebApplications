package com.umcs.barbershop.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServiceDto {
    String name;
    int price;
}
