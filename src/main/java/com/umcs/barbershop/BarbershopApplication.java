package com.umcs.barbershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.umcs.barbershop.infrastructure.persistence"})
@EntityScan(basePackages = {"com.umcs.barbershop.infrastructure.persistence.entity"})
@ComponentScan(basePackages = {"com.umcs.barbershop.infrastructure"})
public class BarbershopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);
	}

}
