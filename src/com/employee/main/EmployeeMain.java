package com.employee.main;

import java.util.List;

import com.employee.domain.Employee;
import com.employee.jdbc.EmployeeServiceImpl;
import com.employee.service.EmployeeService;
import com.employee.util.EmployeeIO;
import com.employee.util.KeyBoard;

public class EmployeeMain extends EmployeeServiceImpl {

	public static void main(String args[]) {
		int option;
		EmployeeService employeeService = new EmployeeServiceImpl();
		do {
			Employee employee = EmployeeIO.read();
			employeeService.add(employee);
			option = KeyBoard.readInt("do you want to continue:(1/0)");
			if (option == 0)
				break;

		} while (option == 1);

		int employeeid = KeyBoard.readInt("Enter employee id to delete");
		Employee employee = employeeService.get(employeeid);
		if (employee == null) {
			KeyBoard.print("Employee doesn't exist with id : " + employeeid);
		} else {
			boolean isDeleted = employeeService.delete(employeeid);
			if (isDeleted) {
				KeyBoard.print("Employee Deleted");
			} else {
				KeyBoard.print("Unable to delete employee");
			}
			List<Employee> employees = employeeService.list();
			EmployeeIO.display(employees);
		}

		int id = KeyBoard.readInt("Enter employee id to update");
		employee = employeeService.get(id);
		if (employee == null) {
			KeyBoard.print("Employee doesn't exist with id : " + id);
		} else {
			Employee newEmployee = EmployeeIO.read();
			employee.setFirstName(newEmployee.getFirstName());
			employee.setLastName(newEmployee.getLastName());
			employee.setEmail(newEmployee.getEmail());
			employee = employeeService.update(employee);
			EmployeeIO.display(employee);
		}
	}

}
