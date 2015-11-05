package com.employee.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.employee.domain.Employee;
import com.employee.service.EmployeeService;
import com.mysql.jdbc.Statement;

public class EmployeeServiceImpl implements EmployeeService {
	List<Employee> employees = new ArrayList<>();

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

		return connection;
	}

	public Employee save(Employee employee) {
		try {
			Connection connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "insert into user1(firstname,lastname,email) values(?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.executeUpdate();
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
                employee.setId(generatedKeys.getInt(1));
            }
			connection.commit();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return employee;
	}

	public boolean delete(int employeeId) {
		boolean isdeleted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = null;
			String sql = "delete from user1 where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			int i = pstmt.executeUpdate();
			if(i == 1) {
				isdeleted =  true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return isdeleted;

	}

	public Employee update(Employee employee) {
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = null;
			String sql = "update user1 set firstname=?,lastname=?,email=?  where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setInt(4, employee.getId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return employee;

	}

	@Override
	public List<Employee> list() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = null;
			String sql = "select * from user1";
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setFirstName(rs.getString(1));
				employee.setLastName(rs.getString(2));
				employee.setId(rs.getInt(3));
				employee.setEmail(rs.getString(4));
				employees.add(employee);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return employees;
	}

	public Employee get(int id) {
		Employee employee = null;
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = null;
			String sql = "select id,firstName,lastName,email from user1 where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				employee = new Employee();
				employee.setId(id);
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setEmail(rs.getString(4));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return employee;
	}

}
