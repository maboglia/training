package com.project.user.customer.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.user.customer.model.models.Person;
import com.project.user.customer.service.implementation.PersonService;

@RestController
@RequestMapping("/rest")
public class PersonController {

	private final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/people")
	public List<Person> getAll(@RequestParam(required = false) List<Integer> person) {
		logger.debug("Acesso al servizio people effetuato con successo");
		if (person == null || person.isEmpty()) {
			return personService.getEvery();
		}
		return personService.find(person);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/people/{id}")
	public Person getOne(@PathVariable("id") int id) {
		return personService.get(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(path = "/people", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person addPerson(@RequestBody Person person) {

		return personService.add(person);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(path = "/people", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person updPerson(@RequestBody Person person) {
		return personService.update(person);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/people/{id}")
	public void deleteOne(@PathVariable("id") int id) {
		personService.delete(id);
	}

}
