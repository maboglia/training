package com.project.user.customer.etcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.user.customer.model.models.Person;
import com.project.user.customer.service.implementation.PersonService;

@Controller
@RequestMapping("/people")
public class PeopleCtrl {

	@Autowired
	private PersonService personService;

	@RequestMapping("")
	public String getPeople(Model model) {
		model.addAttribute("people", personService.getEvery());
		return "elenco_people";
	}

	@PostMapping(path = "/add")
	public String addPerson(@ModelAttribute("person") Person person) {
		personService.add(person);
		return "redirect:/people/";
	}

	@PutMapping(path = "/update")
	public String updatePerson(@ModelAttribute("person") Person person) {
		personService.update(person);
		return "redirect:/people/";
	}

	@PutMapping("/update/{id}")
	public String formPersonUpdate(@PathVariable("id") int id, Model model) {
		Person person = personService.get(id);
		model.addAttribute("person", person);
		return "updatePerson";
	}

	@RequestMapping("/add")
	public String formPerson() {
		return "addPerson";
	}

	@RequestMapping("/{id}")
	public String getPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", personService.get(id));
		return "details";
	}

	@RequestMapping("/delete")
	public String deletePerson(@RequestParam("id") int id) {
		personService.delete(id);
		return "deleted";
	}

}
