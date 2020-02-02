/**
 * 
 */
package com.springboot.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entities.Employee;

/**
 * @author cnoriega
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
