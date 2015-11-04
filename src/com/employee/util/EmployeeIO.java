package com.employee.util;
import java.util.List;

import com.employee.domain.Employee;
public class EmployeeIO {
	public static Employee read() {
		Employee employee = new Employee();

		employee.setId(KeyBoard.readInt("enter id"));
		employee.setFirstName(KeyBoard.readString("enter first name"));
		employee.setEmail(KeyBoard.readString("enter email"));
		employee.setLastName(KeyBoard.readString("enter last name"));
		employee.setSalary(KeyBoard.readInt("enter sal"));
		return employee;
	}
	
	public static void display(Employee employee) {
		System.out.println("Employee First Name : " + employee.getFirstName());
		System.out.println("Employee Last Name : " + employee.getLastName());
		System.out.println("Employee Email : " + employee.getEmail());
		System.out.println("Employee Salary : " + employee.getSalary());
	}
	
	public static void display(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getId());
			System.out.println(employee.getEmail());
		}
	}


}
