package com.umcs.barbershop.domain.usecase;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.port.driving.HaircutRepositoryPort;

import java.util.List;
import java.util.UUID;

public class HaircutService {
    private final HaircutRepositoryPort haircutRepositoryPort;

    public HaircutService(HaircutRepositoryPort haircutRepositoryPort) {
        this.haircutRepositoryPort = haircutRepositoryPort;
    }

    public List<Haircut> getHaircuts() {
        return this.haircutRepositoryPort.findAll();
    }

    public Haircut addHaircut(Haircut haircut) {
        return haircutRepositoryPort.addHaircut(haircut);
    }

    public Haircut getHaircutById(UUID id) {
        return this.haircutRepositoryPort.getHaircutById(id);
    }

    public Haircut updateHaircut(UUID id, Haircut haircut) {
        return this.haircutRepositoryPort.updateHaircut(id, haircut);
    }

    public Haircut deleteHaircutById(UUID id) {
        return this.haircutRepositoryPort.deleteHaircutById(id);
    }
}
