package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.driven.VisitServicePort;
import com.umcs.barbershop.infrastructure.dto.VisitDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/visit")
public class VisitController {
    private final VisitServicePort visitServicePort;

    //    @Autowired
    public VisitController(VisitServicePort visitServicePort) {
        this.visitServicePort = visitServicePort;
    }

    @GetMapping
    public List<Visit> getVisits() {
        return visitServicePort.getVisits();
    }

    @GetMapping(path = "{id}")
    public Visit getVisitById(@PathVariable("id") UUID id) {
        return visitServicePort.getVisitById(id);
    }
    @PostMapping
    public Visit addVisit(@RequestBody VisitDto visitDto) {
        return visitServicePort.addVisit(
                new Visit(null,
                        visitDto.getCreatedDate(),
                        visitDto.getVisitDate(),
                        visitDto.getHaircut(),
                        visitDto.getBarber(),
                        visitDto.getCustomer())
        );
    }

    @DeleteMapping(path = "{id}")
    public void deleteVisit(@PathVariable("id") UUID id) {
        visitServicePort.deleteVisitById(id);
    }


}
