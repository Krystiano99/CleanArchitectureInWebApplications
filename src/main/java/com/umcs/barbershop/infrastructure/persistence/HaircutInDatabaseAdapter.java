package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.port.driving.HaircutRepositoryPort;

import com.umcs.barbershop.infrastructure.persistence.entity.HaircutEntity;
import com.umcs.barbershop.infrastructure.persistence.repository.HaircutRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class HaircutInDatabaseAdapter implements HaircutRepositoryPort {

    private final HaircutRepository haircutRepository;

    public HaircutInDatabaseAdapter(HaircutRepository haircutRepository) {
        this.haircutRepository = haircutRepository;
    }

    @Override
    public List<Haircut> findAll() {
        return haircutRepository.findAll().stream()
                .map(haircutEntity -> new Haircut(
                        haircutEntity.getId(),
                        haircutEntity.getName(),
                        haircutEntity.getPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Haircut addHaircut(Haircut haircut) {
        HaircutEntity result = haircutRepository.save(new HaircutEntity(
                haircut.getId(),
                haircut.getName(),
                haircut.getPrice()
        ));
        return new Haircut(result.getId(), result.getName(), result.getPrice());
    }

    public Haircut getHaircutById(UUID id) {
        Optional<HaircutEntity> result = haircutRepository.findById(id);

        if(result.isEmpty()) {
            return null;
        }

        return new Haircut(result.get().getId(), result.get().getName(), result.get().getPrice());
    }

    @Override
    public Haircut updateHaircut(UUID id, Haircut haircut) {
        HaircutEntity serviceToUpdate = haircutRepository.findById(id).get();

        serviceToUpdate.setName(haircut.getName());
        serviceToUpdate.setPrice(haircut.getPrice());

        HaircutEntity result = haircutRepository.save(serviceToUpdate);

        return new Haircut(result.getId(), result.getName(), result.getPrice());
    }
    @Override
    public Haircut deleteHaircutById(UUID id) {
        HaircutEntity serviceToDelete = haircutRepository.findById(id).get();
        haircutRepository.deleteById(id);
        return new Haircut(serviceToDelete.getId(), serviceToDelete.getName(), serviceToDelete.getPrice());
    }

}