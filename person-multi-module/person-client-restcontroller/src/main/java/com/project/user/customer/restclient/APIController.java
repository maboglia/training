package com.project.user.customer.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.user.customer.service.client.DTOClientLibroService;
import com.user.project.customer.libreria.dtomodel.DTOLibro;

@RestController
@RequestMapping("/client")
public class APIController {

	@Autowired
	private DTOClientLibroService restClient;

	
	@GetMapping("/libri")
	public DTOLibro[] getAll() {
		return restClient.getALL();
	}

	@GetMapping("/librodto/{id}")
	public DTOLibro getOne(@PathVariable("id") int id) {
		return restClient.get(id);
	}

	@PostMapping("/librodto")
	public DTOLibro addLibro(@RequestBody DTOLibro dtoLibro) {
		return restClient.add(dtoLibro);
	}

	@PutMapping("/librodto/{id}")
	public String updateProduct(@PathVariable("id") int id, @RequestBody DTOLibro dto) {
		restClient.update(id, dto);
		return "Updated";

	}

	@DeleteMapping("/librodto/{id}")
	public String deleteOne(@PathVariable("id") int id) {
		restClient.delete(id);
		return "Deleted!";
	}

}
