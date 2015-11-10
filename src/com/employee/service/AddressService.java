package com.employee.service;

import com.employee.domain.Address;
import java.util.List;

public interface AddressService {
	Address save(Address address);

	boolean delete(int id);

	Address update(Address address);

	List<Address> list();

	Address get(int id);

}
