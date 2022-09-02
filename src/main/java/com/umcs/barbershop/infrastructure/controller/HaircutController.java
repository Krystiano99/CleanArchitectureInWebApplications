package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.port.driven.HaircutServicePort;
import com.umcs.barbershop.infrastructure.dto.HaircutDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/haircut")
public class HaircutController {
    private final HaircutServicePort haircutServicePort;

    public HaircutController(HaircutServicePort haircutServicePort) {
        this.haircutServicePort = haircutServicePort;
    }

    @GetMapping
    public List<Haircut> getHaircuts() {
        return haircutServicePort.getHaircuts();
    }

    @PostMapping
    public Haircut addHaircut(@RequestBody HaircutDto haircutDto) {
        return haircutServicePort.addHaircut(
                new Haircut(null,
                        haircutDto.getName(),
                        haircutDto.getPrice())
        );
    }

    @DeleteMapping(path = "{haircutId}")
    public void deleteHaircut(@PathVariable("haircutId") UUID haircutId) {
        haircutServicePort.deleteHaircutById(haircutId);
    }

    @PatchMapping("{haircutId}")
    public Haircut updateHaircut(@PathVariable UUID haircutId, @RequestBody HaircutDto haircutDto) {
        return haircutServicePort.updateHaircut(haircutId, new Haircut(haircutId, haircutDto.getName(), haircutDto.getPrice()));
    }

}
