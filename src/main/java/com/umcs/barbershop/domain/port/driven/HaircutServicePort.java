package com.umcs.barbershop.domain.port.driven;

import com.umcs.barbershop.domain.model.Haircut;

import java.util.List;
import java.util.UUID;

public interface HaircutServicePort {
    List<Haircut> getHaircuts();
    Haircut addHaircut(Haircut haircut);
    Haircut updateHaircut(UUID id, Haircut haircut);
    Haircut deleteHaircutById(UUID id);
}
