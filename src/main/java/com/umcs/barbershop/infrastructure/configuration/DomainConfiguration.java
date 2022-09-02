package com.umcs.barbershop.infrastructure.configuration;

import com.umcs.barbershop.domain.port.driven.OpinionServicePort;
import com.umcs.barbershop.domain.port.driving.HaircutRepositoryPort;
import com.umcs.barbershop.domain.port.driving.OpinionRepositoryPort;
import com.umcs.barbershop.domain.port.driving.UserRepositoryPort;

import com.umcs.barbershop.domain.port.driving.VisitRepositoryPort;
import com.umcs.barbershop.domain.port.driven.HaircutServicePort;
import com.umcs.barbershop.domain.port.driven.UserServicePort;

import com.umcs.barbershop.domain.port.driven.VisitServicePort;
import com.umcs.barbershop.domain.usecase.HaircutService;
import com.umcs.barbershop.domain.usecase.OpinionService;
import com.umcs.barbershop.domain.usecase.UserService;

import com.umcs.barbershop.domain.usecase.VisitService;
import com.umcs.barbershop.infrastructure.adapter.HaircutServiceAdapter;
import com.umcs.barbershop.infrastructure.adapter.OpinionServiceAdapter;
import com.umcs.barbershop.infrastructure.adapter.UserServiceAdapter;

import com.umcs.barbershop.infrastructure.adapter.VisitServiceAdapter;

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
    public VisitService visitService(VisitRepositoryPort visitRepositoryPort, HaircutService haircutService, UserService userService) {
        return new VisitService(visitRepositoryPort, haircutService, userService);
    }

    @Bean
    public HaircutServicePort haircutServicePort(HaircutService haircutService) {
        return new HaircutServiceAdapter(haircutService);
    }

    @Bean
    public HaircutService haircutService(HaircutRepositoryPort haircutRepositoryPort) {
        return new HaircutService(haircutRepositoryPort);
    }

    @Bean
    public OpinionServicePort opinionServicePort(OpinionService opinionService) {
        return new OpinionServiceAdapter(opinionService);
    }

    @Bean
    public OpinionService opinionService(OpinionRepositoryPort opinionRepositoryPort, UserService userService) {
        return new OpinionService(opinionRepositoryPort, userService);
    }
}
