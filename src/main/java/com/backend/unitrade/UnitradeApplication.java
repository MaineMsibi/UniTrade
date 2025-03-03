package com.backend.unitrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.backend") // Ensures Spring scans all components
@EntityScan(basePackages = "com.backend.entity") // Ensures Hibernate scans entities
@EnableJpaRepositories(basePackages = "com.backend.repository") 
public class UnitradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitradeApplication.class, args);
	}

}
