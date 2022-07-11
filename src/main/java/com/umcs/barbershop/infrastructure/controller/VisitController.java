package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.infrastructure.entity.VisitEntity;
import com.umcs.barbershop.infrastructure.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit")
public class VisitController {

    private final VisitService visitService;
    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public List<VisitEntity> getVisits() {
        return visitService.getVisits();
    }

    @PostMapping
    public void registerNewVisit(@RequestBody VisitEntity visitEntity) {
        visitService.addNewVisit(visitEntity);
    }

    @DeleteMapping(path = "{visitId}")
    public void deleteVisit(@PathVariable("visitId") Long visitId) {
        visitService.deleteVisit(visitId);
    }

    @PutMapping(path = "{visitId}")
    public void updateVisit(
            @PathVariable("visitId") Long visitId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        visitService.updateVisit(visitId, name, email);
    }





}


