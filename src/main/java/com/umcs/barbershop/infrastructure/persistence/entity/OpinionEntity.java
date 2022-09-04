package com.umcs.barbershop.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OpinionEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    private AppUserEntity customerEntity;
    private String comment;
    private int rate;
}
