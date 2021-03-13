package com.user.project.customer.libreria.app.restcontroller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.project.customer.libreria.app.model.Libro;
import com.user.project.customer.libreria.app.service.LibroService;
import com.user.project.customer.libreria.dtomodel.DTOLibro;
import com.user.project.cutomer.libreria.app.converter.Converter;


@RestController
@RequestMapping("/rest")
public class LibriRestController {
	
	@Autowired
	private LibroService libroService;

	@GetMapping("/libri")
	public List<DTOLibro> getAll() {
		return libroService.getLibri().stream().map(DTOLibro::new).collect(Collectors.toList());
	}

	@GetMapping("/libri/{id}")
	public DTOLibro getOne(@PathVariable("id") int id) {
		return Converter.toDTO(libroService.getLibro(id));
	}

	@PostMapping("/libri")
	public Libro addLibro(@RequestBody DTOLibro dtoLibro) {
		return libroService.addLibro(Converter.toModel(dtoLibro));
	}

	@PutMapping("/libri/{id}")
	public Libro updLibro(@RequestBody DTOLibro dtoLibro, @PathVariable("id") Integer id) {
		return libroService.updateLibro(Converter.toModel(dtoLibro), id);
	}

	@DeleteMapping("/libri/{id}")
	public void deleteOne(@PathVariable("id") int id) {
		libroService.deleteLibro(id);
	}
	
}
