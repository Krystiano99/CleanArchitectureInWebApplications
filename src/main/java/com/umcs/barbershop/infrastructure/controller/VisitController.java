package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.Visit;
import com.umcs.barbershop.domain.port.driven.VisitServicePort;
import com.umcs.barbershop.infrastructure.dto.VisitDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit")
public class VisitController {
    private final VisitServicePort visitServicePort;

    public VisitController(VisitServicePort visitServicePort) {
        this.visitServicePort = visitServicePort;
    }

    @GetMapping
    public List<Visit> getVisits() {
        return visitServicePort.getVisits();
    }

    @PostMapping(path = "/schedule")
    public Visit scheduleVisit(@RequestBody VisitDto visitDto) {
        return visitServicePort.scheduleVisit(
                visitDto.getCustomerId(),
                visitDto.getBarberId(),
                visitDto.getHaircutId(),
                visitDto.getVisitDate()
        );
    }

    @PostMapping(path = "/cancel")
    public Visit cancelVisit(@RequestBody VisitDto visitDto) {
        return visitServicePort.cancelVisit(visitDto.getId(),visitDto.getCustomerId(), visitDto.getBarberId());
    }


}
