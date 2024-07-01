package com.microservicio.recomendacionProfesores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RecomendacionProfesoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomendacionProfesoresApplication.class, args);
	}

}
