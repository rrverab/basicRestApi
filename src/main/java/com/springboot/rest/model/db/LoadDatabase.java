package com.springboot.rest.model.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.rest.entities.Employee;
import com.springboot.rest.repositories.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository employeeRepository) {
		return args -> {
			log.info("Preloading " + employeeRepository.save(new Employee("Karim Benzema", "Real Madrid ST")));
			log.info("Preloading " + employeeRepository.save(new Employee("Edison Kavani", "Paris Saint Germain ST")));
		};
	}
	
}
