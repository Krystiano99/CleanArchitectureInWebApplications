package com.umcs.barbershop.domain.model;

import java.util.UUID;

public class Opinion {
    private UUID id;
    private User customer;
    private int rate;
    private String comment;

    public Opinion(UUID id, User customer, int rate, String comment) {
        this.id = id;
        this.customer = customer;
        this.rate = rate;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
