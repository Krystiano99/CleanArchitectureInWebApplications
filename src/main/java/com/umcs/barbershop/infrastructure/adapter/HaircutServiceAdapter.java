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
    public List<Haircut> getServices() {
        return haircutService.getHaircuts();
    }

    @Override
    public Haircut addService(Haircut haircut) {
        return haircutService.addHaircut(haircut);
    }

    @Override
    public Haircut getServiceById(UUID id) {
        return haircutService.getHaircutById(id);
    }

    @Override
    public Haircut updateService(UUID id, Haircut haircut) {
        return haircutService.updateHaircut(id, haircut);
    }

    @Override
    public Haircut deleteServiceById(UUID id) {
        return haircutService.deleteHaircutById(id);
    }

}
