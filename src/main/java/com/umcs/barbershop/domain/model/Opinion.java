package com.umcs.barbershop.domain.model;

import java.util.UUID;

public class Opinion {
    private UUID id;
    private User customer;
    private int assessment;
    private String comment;

    public Opinion(UUID id, User customer, int assessment, String comment) {
        this.id = id;
        this.customer = customer;
        this.assessment = assessment;
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

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
