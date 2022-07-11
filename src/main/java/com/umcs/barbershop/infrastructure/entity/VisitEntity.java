package com.umcs.barbershop.infrastructure.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class VisitEntity {
    @Id
    @SequenceGenerator(
            name = "visit_sequence",
            sequenceName = "visit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "visit_sequence"
    )
    private Long id;
    private Long customerId;
    private Long barberId;
    private Long serviceId;
    @CreatedDate
    private Date createdDate;
    private LocalDate visitDate;

    public VisitEntity(Long customerId, Long barberId, Long serviceId, LocalDate visitDate) {
        this.customerId = customerId;
        this.barberId = barberId;
        this.serviceId = serviceId;
        this.visitDate = visitDate;
    }

    public VisitEntity() {

    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", barberId=" + barberId +
                ", serviceId=" + serviceId +
                ", createdDate=" + createdDate +
                ", visitDate=" + visitDate +
                '}';
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
