package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.Haircut;
import com.umcs.barbershop.domain.port.driven.HaircutServicePort;
import com.umcs.barbershop.infrastructure.dto.HaircutDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/service")
public class HaircutController {
    private final HaircutServicePort haircutServicePort;

    //    @Autowired
    public HaircutController(HaircutServicePort haircutServicePort) {
        this.haircutServicePort = haircutServicePort;
    }

    @GetMapping
    public List<Haircut> getServices() {
        return haircutServicePort.getServices();
    }

    @PostMapping
    public Haircut addService(@RequestBody HaircutDto haircutDto) {
        return haircutServicePort.addService(
                new Haircut(null,
                        haircutDto.getName(),
                        haircutDto.getPrice())
        );
    }

    @DeleteMapping(path = "{serviceId}")
    public void deleteService(@PathVariable("serviceId") UUID serviceId) {
        haircutServicePort.deleteServiceById(serviceId);
    }

//    @PutMapping(path = "{userId}")
//    public void updateUser(
//            @PathVariable("userId") Long userId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email) {
//        userServicePort.updateUser(userId, name, email);
//    }

}
