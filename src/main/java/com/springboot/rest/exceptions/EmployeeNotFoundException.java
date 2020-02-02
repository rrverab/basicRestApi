package com.springboot.rest.exceptions;

import org.springframework.web.bind.annotation.PathVariable;

public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException(Long id) {
		super("Could not find employee" + id);
	}
}
