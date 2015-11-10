package com.employee.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employee.domain.Address;
import com.employee.service.AddressService;

public class AddressServiceImpl implements AddressService {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		return connection;
	}

	public Address save(Address address) {
		try {
			Connection connection = getConnection();
			connection.setAutoCommit(false);
			String sql = "insert into user1 (id,city,state,country,pincode) values(?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, address.getId());
			pstmt.setString(2, address.getCity());
			pstmt.setString(3, address.getState());
			pstmt.setString(4, address.getCountry());
			pstmt.setInt(5, address.getPincode());
			pstmt.executeUpdate();
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				address.setId(generatedKeys.getInt(1));
			}
			connection.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return address;
	}

	public boolean delete(int id) {
		boolean isdeleted = false;

		try {
			Connection connection = getConnection();
			String sql = "delete from user1 where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				isdeleted = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isdeleted;
	}

	public Address update(Address address) {
		try {
			Connection connection = getConnection();
			String sql = "update user1 set id=?,city=?,state=?,country=?,pincode=? where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, address.getId());
			pstmt.setString(2, address.getCity());
			pstmt.setString(3, address.getState());
			pstmt.setString(4, address.getCountry());
			pstmt.setInt(5, address.getPincode());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return address;
	}

	public List<Address> list() {
		List<Address> addresses = new ArrayList<>();
		try {
			Connection connection = getConnection();
			String sql = "select id,city,state,country,pincode from user1";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Address address = new Address();
				address.setId(rs.getInt(1));
				address.setCity(rs.getString(2));
				address.setState(rs.getString(3));
				address.setCountry(rs.getString(4));
				address.setPincode(rs.getInt(5));
				addresses.add(address);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return addresses;
	}

	public Address get(int id) {
		Address address = new Address();
		try {
			Connection connection = getConnection();
			String sql = "select id,city,state,country,pincode from user1 where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				address.setId(rs.getInt(1));
				address.setCity(rs.getString(2));
				address.setState(rs.getString(3));
				address.setCountry(rs.getString(4));
				address.setPincode(rs.getInt(5));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return address;
	}

}
