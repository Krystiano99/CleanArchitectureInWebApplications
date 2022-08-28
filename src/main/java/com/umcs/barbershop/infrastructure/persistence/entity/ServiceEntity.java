package com.umcs.barbershop.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private int price;


//    public UUID getId() {
//        return id;
//    }

}
