package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.model.Opinion;
import com.umcs.barbershop.domain.model.User;
import com.umcs.barbershop.domain.port.driven.HaircutServicePort;
import com.umcs.barbershop.domain.port.driven.OpinionServicePort;
import com.umcs.barbershop.infrastructure.dto.HaircutDto;
import com.umcs.barbershop.infrastructure.dto.OpinionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/opinion")
public class OpinionController {
    private final OpinionServicePort opinionServicePort;

    public OpinionController(OpinionServicePort opinionServicePort) {
        this.opinionServicePort = opinionServicePort;
    }

    @GetMapping
    public List<Opinion> getOpinions() {
        return opinionServicePort.getOpinions();
    }

    @PostMapping
    public Opinion addOpinion(@RequestBody OpinionDto opinionDto) {
        return opinionServicePort.addOpinion(
                new Opinion(null,
                        opinionDto.getCustomer(),
                        opinionDto.getAssessment(),
                        opinionDto.getComment())
        );
    }

    @GetMapping(path = "{id}")
    public Opinion getOpinionById(@PathVariable("id") UUID id) {
        return opinionServicePort.getOpinionById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOpinion(@PathVariable("id") UUID id) {
        opinionServicePort.deleteOpinionById(id);
    }

}
