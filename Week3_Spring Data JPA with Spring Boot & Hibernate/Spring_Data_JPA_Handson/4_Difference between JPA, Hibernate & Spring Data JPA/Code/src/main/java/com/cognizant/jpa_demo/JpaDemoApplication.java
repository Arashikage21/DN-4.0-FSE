package com.cognizant.jpa_demo;

import com.cognizant.jpa_demo.model.Employee;
import com.cognizant.jpa_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService service;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Employee emp = service.addEmployee(new Employee("Bob"));
		System.out.println("Spring Data JPA saved Employee with ID: " + emp.getId());
	}
}

