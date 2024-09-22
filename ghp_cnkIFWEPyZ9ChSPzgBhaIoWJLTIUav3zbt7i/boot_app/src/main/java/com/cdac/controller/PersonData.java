package com.cdac.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Status;

import com.cdac.entity.Person;
import com.cdac.repository.PrsonRepo;

@RestController
@CrossOrigin
public class PersonData {

	@Autowired
	private PrsonRepo personRepo;
	
	
	@PostMapping("/personAddV2")
	public Status addV2(@RequestBody Person person) {
		//prRepo.save(person);
		
		personRepo.addPerson(person);
		Status status=new Status();
		status.setMsg("data addedV2...");
		status.setStatus("succes.V2..");
		return status;
	}
	@PostMapping("/fetchPerson")
	public List<Person> fetchP() {
		//prRepo.save(person);
		
	     List<Person> person = personRepo.fetch();
	     
	     /*for(Person p:person) {
	    	 p.getName();
	    	 p.getAge();
	    	 p.getEmail();
	     }*/
		return  person;
	}
	
}
