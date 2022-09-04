package com.umcs.barbershop.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private Date createdDate;
    private Date visitDate;
    @OneToOne
    private HaircutEntity haircutEntity;
    @OneToOne
    private AppUserEntity barberEntity;
    @OneToOne
    private AppUserEntity customerEntity;


}
