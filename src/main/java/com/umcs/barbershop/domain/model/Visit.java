package com.umcs.barbershop.domain.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Visit {
    private UUID id;
    private Date createdDate;
    private LocalDate visitDate;
    private Service service;
    private User barber;
    private User customer;

    public Visit(UUID id, Date createdDate, LocalDate visitDate, Service service, User barber, User customer) {
        this.id = id;
        this.createdDate = createdDate;
        this.visitDate = visitDate;
        this.service = service;
        this.barber = barber;
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public User getBarber() {
        return barber;
    }

    public void setBarber(User barber) {
        this.barber = barber;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
