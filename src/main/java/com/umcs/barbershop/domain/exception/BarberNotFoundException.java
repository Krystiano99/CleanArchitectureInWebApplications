package com.umcs.barbershop.domain.exception;

public class BarberNotFoundException extends RuntimeException {
    public BarberNotFoundException(String s) {
        super(s);
    }
}
