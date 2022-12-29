package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}		
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//check whether employee with id exist in database or not
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "Id", id));
		
		//updating value
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//saving updates
		employeeRepository.save(existingEmployee);
			
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		
		//check whether employee exist
		employeeRepository.findById(id).orElseThrow(()->
		                       new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		
	}
	
	@Override
	public List<Employee> findByfirstName(String firstName) {
		List<Employee> p=employeeRepository.findByfirstName(firstName);
		return p;
	}
	
	@Override
	public List<Employee> findBylastName(String lastName) {
		List<Employee> p=employeeRepository.findBylastName(lastName);
		return p;
	}
}
