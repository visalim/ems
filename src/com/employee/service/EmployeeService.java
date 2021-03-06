package com.employee.service;

import com.employee.domain.Employee;
import java.util.List;


public interface EmployeeService {

	Employee save(Employee employee);

	boolean delete(int id);

	Employee update(Employee employee);

	List<Employee> list();

	Employee get(int id);

}
