package com.umcs.barbershop.persistance.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class VisitModel{
    @Id
    private Long id;

    private LocalDate visitDate;



}
