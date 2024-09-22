package com.cdac.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdac.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Component
public class PrsonRepo {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addPerson(Person person) {
		em.persist(person);
	}
	@Transactional
	public List<Person> fetch(){
		String q="select p from Person p";
		Query  query = em.createQuery(q);
		List<Person> person = query.getResultList();
		return person;
		
	}


}
