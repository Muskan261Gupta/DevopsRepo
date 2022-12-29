package com.example.service;

import java.util.List;
import com.example.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
	public List<Employee> findByfirstName(String firstName);
	public List<Employee> findBylastName(String lastName);
}
