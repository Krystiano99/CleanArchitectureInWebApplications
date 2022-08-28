package com.umcs.barbershop.infrastructure.controller;

import com.umcs.barbershop.domain.model.Service;
import com.umcs.barbershop.domain.port.service.ServiceServicePort;
import com.umcs.barbershop.infrastructure.dto.ServiceDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    private final ServiceServicePort serviceServicePort;

    //    @Autowired
    public ServiceController(ServiceServicePort serviceServicePort) {
        this.serviceServicePort = serviceServicePort;
    }

    @GetMapping
    public List<Service> getServices() {
        return serviceServicePort.getServices();
    }

    @PostMapping
    public Service addService(@RequestBody ServiceDto serviceDto) {
        return serviceServicePort.addService(
                new Service(null,
                        serviceDto.getName(),
                        serviceDto.getPrice())
        );
    }

    @DeleteMapping(path = "{serviceId}")
    public void deleteService(@PathVariable("serviceId") UUID serviceId) {
        serviceServicePort.deleteServiceById(serviceId);
    }

//    @PutMapping(path = "{userId}")
//    public void updateUser(
//            @PathVariable("userId") Long userId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email) {
//        userServicePort.updateUser(userId, name, email);
//    }

}
