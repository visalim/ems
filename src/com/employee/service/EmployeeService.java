package com.employee.service;
import  com.employee.domain.Employee;
import java.util.List;
public interface EmployeeService {

		void add(Employee employee);

		boolean delete(int id);

		void display();

		Employee update(Employee employee);
		List<Employee> list();

		Employee get(int id);
		
	}
	


