package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.Opinion;
import com.umcs.barbershop.domain.port.driven.OpinionServicePort;
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
        return opinionServicePort.leaveOpinion(
                        opinionDto.getCustomerId(),
                        opinionDto.getRate(),
                        opinionDto.getComment());
    }

    @DeleteMapping(path = "{id}")
    public void deleteOpinion(@PathVariable("id") UUID id) {
        opinionServicePort.deleteOpinionById(id);
    }

    @GetMapping(path = "/average")
    public double getAverageRating(){
        return opinionServicePort.getAverageRating();
    }

}
