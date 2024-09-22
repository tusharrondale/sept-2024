package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Address;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerException;
import com.cdac.repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	public int register(Customer customer) {
		Optional<Customer> customerCheck = customerRepo.findByEmail(customer.getEmail());
		if (customerCheck.isEmpty()) {
			Address address = customer.getAddress();
			if(address != null)
				address.setCustomer(customer);
		Customer saveCust =	customerRepo.save(customer);
		return saveCust.getId();
		
		} else
			throw new CustomerException("Customer already present....");

	}
}
