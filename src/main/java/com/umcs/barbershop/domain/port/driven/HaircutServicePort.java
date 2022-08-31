package com.umcs.barbershop.domain.port.driven;

import com.umcs.barbershop.domain.model.Haircut;

import java.util.List;
import java.util.UUID;

public interface HaircutServicePort {
    List<Haircut> getServices();
    Haircut getServiceById(UUID id);
    Haircut addService(Haircut haircut);
    Haircut updateService(UUID id, Haircut haircut);
    Haircut deleteServiceById(UUID id);
}
