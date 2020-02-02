/**
 * 
 */
package com.springboot.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.entities.Employee;
import com.springboot.rest.exceptions.EmployeeNotFoundException;
import com.springboot.rest.repositories.EmployeeRepository;

/**
 * @author cnoriega
 *
 */
@RestController
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	  EmployeeController(EmployeeRepository employeeRepository) {
	    this.employeeRepository = employeeRepository;
	  }

	  // Aggregate root

	  @GetMapping("/employees")
	  List<Employee> getAll() {
	    return employeeRepository.findAll();
	  }

	  @PostMapping("/employees")
	  public Employee getNewEmployee(@RequestBody Employee newEmployee) {
	    return employeeRepository.save(newEmployee);
	  }

	  // Single item

	  @GetMapping("/employees/{id}")
	  public Employee getOne(@PathVariable Long id) {

	    return employeeRepository.findById(id)
	      .orElseThrow(() -> new EmployeeNotFoundException(id));
	  }

	  @PutMapping("/employees/{id}")
	  public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

	    return employeeRepository.findById(id)
	      .map(employee -> {
	        employee.setName(newEmployee.getName());
	        employee.setRole(newEmployee.getRole());
	        return employeeRepository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setId(id);
	        return employeeRepository.save(newEmployee);
	      });
	  }

	  @DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable Long id) {
		  employeeRepository.deleteById(id);
	  }
}
