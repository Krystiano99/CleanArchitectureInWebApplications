package com.umcs.barbershop.infrastructure.persistence;

import com.umcs.barbershop.domain.port.repository.ServiceRepositoryPort;
import com.umcs.barbershop.domain.port.repository.UserRepositoryPort;
import com.umcs.barbershop.domain.port.repository.VisitRepositoryPort;
import com.umcs.barbershop.infrastructure.persistence.repository.ServiceRepository;
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
    public ServiceRepositoryPort serviceRepositoryPort(ServiceRepository serviceRepository) {
        return new ServiceInDatabaseAdapter(serviceRepository);
    }

    @Bean
    public VisitRepositoryPort visitRepositoryPort(VisitRepository visitRepository) {
        return new VisitInDatabaseAdapter(visitRepository);
    }
}

