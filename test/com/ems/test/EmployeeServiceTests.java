package com.ems.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.employee.domain.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.impl.EmployeeServiceImpl;
import java.util.List;
import java.util.ArrayList;

public class EmployeeServiceTests {

	private EmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
		employeeService = new EmployeeServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		Employee employee = new Employee();
		employee.setFirstName("Visali");
		employee.setLastName("Masina");
		employee.setEmail("visalimasina@gmail.com");
	
		Employee savedEmployee = employeeService.save(employee);
		
		assertEquals(employee.getFirstName(), savedEmployee.getFirstName());
		assertNotEquals(savedEmployee.getId(), 0);
		
	}

	@Test
	public void testDelete() {
		
		Employee employee = new Employee();
		employee.setFirstName("Visali");
		employee.setLastName("Masina");
		employee.setEmail("visalimasina@gmail.com");
	
		Employee savedEmployee = employeeService.save(employee);
		boolean isDeleted = employeeService.delete(savedEmployee.getId());
        assertEquals(isDeleted,true);
	}
	@Test
	public void  testUpdate(){
		Employee employee=new Employee();
		employee.setFirstName("visali");
		employee.setLastName("masina");
		employee.setEmail("vishalimasina@gmail.com");
		Employee savedEmployee = employeeService.save(employee);
		savedEmployee.setFirstName("vasavi");
		savedEmployee.setLastName("manne");
		savedEmployee.setEmail("mannevasavi@gmail.com");
		Employee updatedemployee=employeeService.update(savedEmployee);
		assertEquals(updatedemployee.getId(),savedEmployee.getId());
}
	@Test
	public void testList(){
     		Employee employee=new Employee();
     		employee.setFirstName("visali");
     		employee.setLastName("masina");
	        employee.setEmail("vishalmasina@gmail.com");
	        employeeService.save(employee);
	        List<Employee> employees = employeeService.list();
	        assertNotNull(employees);
		
	}
	@Test
	public void testGet(){
		Employee employee=new Employee();
		Employee savedEmployee=employeeService.save(employee);
	    Employee getemployee=employeeService.get(savedEmployee.getId());
	    assertNotNull(getemployee);
		
	}
	}
