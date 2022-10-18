package com.example.retos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(scanBasePackages = {"com.example.retos"})
//@EntityScan("com.example.retos.Model")
//@EnableJpaRepositories("com.example.retos.Repository")
public class RetosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetosApplication.class, args);
	}

}
