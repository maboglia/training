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

import com.project.user.customer.model.models.Address;
import com.project.user.customer.service.implementation.AddressService;


@Controller
@RequestMapping("/address")
public class AddressesCtrl {

	@Autowired
	private AddressService as;

	@RequestMapping("")
	public String getAddress(Model model) {
		model.addAttribute("addresses", as.getEvery());
		return "elenco_address";
	}

	@PostMapping(path = "/add")
	public String addAddress(@ModelAttribute("address") Address address) {
		as.add(address);
		return "redirect:/people/";
	}

	@PutMapping(path = "/update")
	public String updateAddress(@ModelAttribute("Address") Address address) {
		as.update(address);
		return "redirect:/people/";
	}

	@PutMapping("/update/{id}")
	public String formAddressUpdate(@PathVariable("id") int id, Model model) {
		Address address = as.get(id);
		model.addAttribute("Address", address);
		return "updateAddress";
	}

	@RequestMapping("/add")
	public String formAddress() {
		return "addAddress";
	}

	@RequestMapping("/{id}")
	public String getAddress(@PathVariable("id") int id, Model model) {
		// to add Address al model
		model.addAttribute("Address", as.get(id));
		return "details";
	}

	@RequestMapping("/delete")
	public String deleteAddress(@RequestParam("id") int id) {
		as.delete(id);
		return "deleted";
	}

}
