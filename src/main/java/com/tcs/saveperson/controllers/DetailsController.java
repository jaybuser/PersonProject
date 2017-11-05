package com.tcs.saveperson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.saveperson.model.Person;
import com.tcs.saveperson.repositorys.PersonRepository;

@RestController
public class DetailsController {

	@Autowired
	private PersonRepository personRepo;
	
	@RequestMapping(value = "/personDetails")
	public String addPerson() {
		
		List<Person> persons = personRepo.findAll();
		String personName="No name saved";
		
		if(persons.size()>0) {
			personName=persons.get(0).getName();
		}
		
		return personName;
	}
}
