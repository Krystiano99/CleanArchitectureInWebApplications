package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.port.driving.HaircutRepositoryPort;
import com.umcs.barbershop.domain.port.driving.OpinionRepositoryPort;
import com.umcs.barbershop.domain.port.driving.UserRepositoryPort;
import com.umcs.barbershop.domain.port.driving.VisitRepositoryPort;
import com.umcs.barbershop.infrastructure.persistence.repository.HaircutRepository;
import com.umcs.barbershop.infrastructure.persistence.repository.OpinionRepository;
import com.umcs.barbershop.infrastructure.persistence.repository.UserRepository;
import com.umcs.barbershop.infrastructure.persistence.repository.VisitRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceInDatabaseConfiguration {
    @Bean
    public UserRepositoryPort userRepositoryPort(UserRepository userRepository) {
        return new UserInDatabaseAdapter(userRepository);
    }

    @Bean
    public HaircutRepositoryPort serviceRepositoryPort(HaircutRepository haircutRepository) {
        return new HaircutInDatabaseAdapter(haircutRepository);
    }

    @Bean
    public VisitRepositoryPort visitRepositoryPort(VisitRepository visitRepository) {
        return new VisitInDatabaseAdapter(visitRepository);
    }

    @Bean
    public OpinionRepositoryPort opinionRepositoryPort(OpinionRepository opinionRepository) {
        return new OpinionInDatabaseAdapter(opinionRepository);
    }
}

