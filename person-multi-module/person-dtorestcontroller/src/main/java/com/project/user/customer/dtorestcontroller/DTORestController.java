package com.project.user.customer.dtorestcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.customer.model.dto.PersonDTO;
import com.project.user.customer.service.implementation.PersonService;

@RequestMapping("/dto")
	@RestController
	public class DTORestController {

		  @Autowired
		  PersonService personService;
		  
		  @GetMapping("/supertest")
		  List<PersonDTO> getUsers2(){
			  return personService.getEvery().stream().map(PersonDTO::new).collect(Collectors.toList());
		  }
		  
		
	}

