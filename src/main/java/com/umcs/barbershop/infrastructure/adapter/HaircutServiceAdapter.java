package com.umcs.barbershop.infrastructure.adapter;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.port.driven.HaircutServicePort;
import com.umcs.barbershop.domain.usecase.HaircutService;

import java.util.List;
import java.util.UUID;

public class HaircutServiceAdapter implements HaircutServicePort {
    private final HaircutService haircutService;

    public HaircutServiceAdapter(HaircutService userService) {
        this.haircutService = userService;
    }

    @Override
    public List<Haircut> getHaircuts() {
        return haircutService.getHaircuts();
    }

    @Override
    public Haircut addHaircut(Haircut haircut) {
        return haircutService.addHaircut(haircut);
    }

    @Override
    public Haircut updateHaircut(UUID id, Haircut haircut) {
        return haircutService.updateHaircut(id, haircut);
    }

    @Override
    public Haircut deleteHaircutById(UUID id) {
        return haircutService.deleteHaircutById(id);
    }

}
