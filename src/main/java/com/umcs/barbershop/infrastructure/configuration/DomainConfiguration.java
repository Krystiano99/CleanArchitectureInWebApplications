package com.umcs.barbershop.infrastructure.configuration;



import com.umcs.barbershop.domain.port.repository.ServiceRepositoryPort;
import com.umcs.barbershop.domain.port.repository.UserRepositoryPort;

import com.umcs.barbershop.domain.port.repository.VisitRepositoryPort;
import com.umcs.barbershop.domain.port.service.ServiceServicePort;
import com.umcs.barbershop.domain.port.service.UserServicePort;

import com.umcs.barbershop.domain.port.service.VisitServicePort;
import com.umcs.barbershop.domain.usecase.ServiceService;
import com.umcs.barbershop.domain.usecase.UserService;

import com.umcs.barbershop.domain.usecase.VisitService;
import com.umcs.barbershop.infrastructure.adapter.ServiceServiceAdapter;
import com.umcs.barbershop.infrastructure.adapter.UserServiceAdapter;

import com.umcs.barbershop.infrastructure.adapter.VisitServiceAdapter;

import com.umcs.barbershop.infrastructure.persistence.ServiceInDatabaseAdapter;
import com.umcs.barbershop.infrastructure.persistence.UserInDatabaseAdapter;
import com.umcs.barbershop.infrastructure.persistence.VisitInDatabaseAdapter;

import com.umcs.barbershop.infrastructure.persistence.repository.ServiceRepository;
import com.umcs.barbershop.infrastructure.persistence.repository.UserRepository;
import com.umcs.barbershop.infrastructure.persistence.repository.VisitRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {
    @Bean
    public UserServicePort userServicePort(UserService userService) {
        return new UserServiceAdapter(userService);
    }

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(userRepositoryPort);
    }

    @Bean
    public VisitServicePort visitServicePort(VisitService visitService) {
        return new VisitServiceAdapter(visitService);
    }

    @Bean
    public VisitService visitService(VisitRepositoryPort visitRepositoryPort, ServiceService serviceService, UserService barberService, UserService customerService) {
        return new VisitService(visitRepositoryPort, serviceService, barberService, customerService);
    }

    @Bean
    public ServiceServicePort serviceServicePort(ServiceService serviceService) {
        return new ServiceServiceAdapter(serviceService);
    }

    @Bean
    public ServiceService serviceService(ServiceRepositoryPort serviceRepositoryPort) {
        return new ServiceService(serviceRepositoryPort);
    }

///////////////////
//    @Bean
//    public UserRepositoryPort userRepositoryPort(UserRepository userRepository) {
//        return new UserInDatabaseAdapter(userRepository);
//    }
//
//    @Bean
//    public ServiceRepositoryPort serviceRepositoryPort(ServiceRepository serviceRepository) {
//        return new ServiceInDatabaseAdapter(serviceRepository);
//    }

//    @Bean
//    public VisitRepositoryPort visitRepositoryPort(VisitRepository visitRepository) {
//        return new VisitInDatabaseAdapter(visitRepository);
//    }
}
