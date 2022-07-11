package com.umcs.barbershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BarbershopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);
	}

}
