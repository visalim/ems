package com.employee.util;
import com.employee.domain.Employee;
public class EmployeeIo {
	public static Employee read() {
		Employee employee = new Employee();

		employee.setId(KeyBoard.readInt("enter id"));
		employee.setFirstName(KeyBoard.readString("enter first name"));
		employee.setEmail(KeyBoard.readString("enter email"));
		employee.setLastName(KeyBoard.readString("enter last name"));
		employee.setSalary(KeyBoard.readInt("enter sal"));
		return employee;
	}
	
	public static void print(Employee employee) {
		System.out.println("Employee First Name : " + employee.getFirstName());
		System.out.println("Employee Last Name : " + employee.getLastName());
		System.out.println("Employee Email : " + employee.getEmail());
		System.out.println("Employee Salary : " + employee.getSalary());
	}


}
