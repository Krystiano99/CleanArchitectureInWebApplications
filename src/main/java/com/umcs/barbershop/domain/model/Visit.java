package com.umcs.barbershop.domain.model;

import java.time.LocalDate;
import java.util.Date;

public class Visit {
    private int id;
    private Date createdDate;
    private LocalDate visitDate;
    private Service serviceEntity;
}
