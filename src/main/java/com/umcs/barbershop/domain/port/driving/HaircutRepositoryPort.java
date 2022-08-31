package com.umcs.barbershop.domain.port.driving;

import com.umcs.barbershop.domain.model.Haircut;

import java.util.List;
import java.util.UUID;

public interface HaircutRepositoryPort {
    List<Haircut> findAll();
    Haircut addHaircut(Haircut haircut);
    Haircut getHaircutById(UUID id);
    Haircut updateHaircut(UUID id, Haircut haircut);
    Haircut deleteHaircutById(UUID id);
}
