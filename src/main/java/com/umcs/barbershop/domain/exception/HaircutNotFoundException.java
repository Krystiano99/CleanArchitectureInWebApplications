package com.umcs.barbershop.domain.exception;

public class HaircutNotFoundException extends RuntimeException {
    public HaircutNotFoundException(String s) {
        super(s);
    }
}
