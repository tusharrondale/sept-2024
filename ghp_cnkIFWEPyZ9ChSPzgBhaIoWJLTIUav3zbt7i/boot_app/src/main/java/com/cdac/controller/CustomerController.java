package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.RStatus;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerException;
import com.cdac.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerServ;
	
	@PostMapping("/custRegister")
	public RStatus registerCust(@RequestBody Customer customer) {
		try {
			int id = customerServ.register(customer);
			RStatus status = new RStatus();
			status.setCustomerId(id);
			status.setStatusMessage("Customer Added...");
			status.setStatus(true);
			return status;
		
		} catch (CustomerException e) {
			RStatus status = new RStatus();
			status.setStatusMessage(e.getMessage());
			status.setStatus(false);
			return status;
		
		}
		}
}
