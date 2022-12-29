package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ResTfulProjectApplicationTests {

	@Autowired
	EmployeeRepository repo;
	
	@Test
	@Order(1)
	public void testCreate() {
		
		Employee emp=new Employee();
		emp.setId(41);
		emp.setFirstName("Hardik");
		emp.setLastName("Jain");
		emp.setEmail("hardik@email.com");
		repo.save(emp);
		assertNotNull(repo.findById((long) 41).get());
	}
	
	@Test
	public void testReadAll() {
		List<Employee> emplist=repo.findAll();
		assertThat(emplist).size().isGreaterThan(0);
	}
	
	@Test
	public void testReadSingle() {
		
//		assertNotNull(repo.findById(40L).get());
		Employee emp=repo.findById(40L).get();
//		System.out.println(emp.toString());
		
		assertEquals("Rohani",emp.getFirstName());
		}
	
	@Test
	public void testupdate() {
		Employee emp=repo.findById(40L).get();
		emp.setFirstName("Rohani");
		repo.save(emp);
		assertNotEquals("Rohan",repo.findById(40L).get().getFirstName());
//		assertEquals("Rohani",repo.findById(40L).get().getFirstName());
	}
	
	@Test
	public void testDelete() {
		repo.deleteById(42L);
		assertThat(repo.existsById(42L)).isFalse();
	}

}
