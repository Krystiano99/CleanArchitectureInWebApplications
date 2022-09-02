package com.umcs.barbershop.domain.model;

import java.util.Date;
import java.util.UUID;

public class Visit {
    private UUID id;
    private Date createdDate;
    private Date visitDate;
    private Haircut haircut;
    private User barber;
    private User customer;

    public Visit(UUID id, Date createdDate, Date visitDate, Haircut haircut, User barber, User customer) {
        this.id = id;
        this.createdDate = createdDate;
        this.visitDate = visitDate;
        this.haircut = haircut;
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
    public Date getVisitDate() {return visitDate;}
    public void setVisitDate(Date visitDate) {this.visitDate = visitDate; }
    public Haircut getHaircut() {return haircut; }
    public void setService(Haircut haircut) {this.haircut = haircut; }
    public User getBarber() {return barber; }
    public void setBarber(User barber) { this.barber = barber; }
    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }
}
