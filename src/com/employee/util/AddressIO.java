package com.employee.util;

import com.employee.domain.Address;
import java.util.List;

public class AddressIO {
	public Address read() {
		Address address = new Address();
		address.setId(KeyBoard.readInt("enter the id of employee"));
		address.setCity(KeyBoard.readString("enter the city of employee"));
		address.setState(KeyBoard.readString("enter the state of employee"));
		address.setCountry(KeyBoard.readString("enter the country of employee"));
		address.setPincode(KeyBoard.readInt("enter the pincode of employee"));
		return address;

	}

	public void display(Address address) {
		System.out.println("emplyee id:" + address.getId());
		System.out.println("employee city:" + address.getCity());
		System.out.println("employee state:" + address.getState());
		System.out.println("employee country:" + address.getCountry());
		System.out.println("employee pincode:" + address.getPincode());
	}

	public void display(List<Address> address) {
		for (Address address1 : address) {
			System.out.println(address1.getId());
			System.out.println("employee city:" + address1.getCity());
			System.out.println("employee State:" + address1.getState());
			System.out.println("employee Country:" + address1.getCountry());
			System.out.println("employee Pincode:" + address1.getPincode());

		}

	}
}