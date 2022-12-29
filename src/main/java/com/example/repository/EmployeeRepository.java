package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	public List<Employee> findByfirstName(String firstName);
	public List<Employee> findBylastName(String lastName);
}
