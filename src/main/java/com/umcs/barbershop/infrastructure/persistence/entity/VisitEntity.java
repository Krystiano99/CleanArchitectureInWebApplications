package com.umcs.barbershop.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class VisitEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private Date createdDate;
    private LocalDate visitDate;
    @OneToOne
    private ServiceEntity serviceEntity;
    @OneToOne
    private UserEntity userEntity;
    @OneToOne
    private UserEntity customerEntity;


}
