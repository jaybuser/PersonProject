package com.tcs.saveperson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.saveperson.model.Person;
import com.tcs.saveperson.repositorys.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personRepo;
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView addPerson() {
		
		Person person=new Person();
		return new ModelAndView("savePerson", "form", person);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePerson(Person person) {
	    personRepo.save(person);
	    return ("redirect:/get");
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getPerson() {
		
		List<Person> persons = personRepo.findAll();
		String personName="No name saved";
		
		if(persons.size()>0) {
			personName=persons.get(0).getName();
		}
		
		
		return new ModelAndView("getPerson","person",personName);
	}

}
