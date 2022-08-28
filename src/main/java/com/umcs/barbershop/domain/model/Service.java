package com.umcs.barbershop.domain.model;

import java.util.UUID;

public class Service {
    private UUID id;
    private String name;
    private int price;

    public Service(UUID id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

