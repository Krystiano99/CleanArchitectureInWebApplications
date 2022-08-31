package com.umcs.barbershop.domain.exception;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(String s) {
        super(s);
    }
}
