package com.user.project.customer.libreria.app.etcontroller;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.user.project.customer.libreria.app.service.LibroService;
import com.user.project.customer.libreria.dtomodel.DTOLibro;
import com.user.project.cutomer.libreria.app.converter.Converter;

@Controller
@RequestMapping("/view")
public class LibriEtController {

	@Autowired
	private LibroService libroService;

	@GetMapping("/libri")
	private String getLibri(Model model) {
		model.addAttribute("libri", libroService.getLibri().stream().map(DTOLibro::new).collect(Collectors.toList()));
		return "elenco_libri";
	}

	@PostMapping("/libri")
	private String addLibro(@ModelAttribute("libro") DTOLibro dtoLibro) {
		libroService.addLibro(Converter.toModel(dtoLibro));
		return "redirect:/libri/";
	}

	@PutMapping("/libri/{id}")
	private String updateLibro(@RequestBody DTOLibro dtoLibro, @PathVariable("id") Integer id) {
		libroService.updateLibro(Converter.toModel(dtoLibro), id);
		return "redirect:/libri/";
	}

	@DeleteMapping("/delete")
	private String deleteLibro(@RequestParam("id") int id) {
		libroService.deleteLibro(id);
		return "redirect:/libri/";
	}

}
