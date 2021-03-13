package com.user.project.customer.libreria.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.project.customer.libreria.app.model.Libro;
import com.user.project.customer.libreria.app.repository.ILibroRepository;

@Service
public class LibroService implements ILibroService {

	@Autowired
	private ILibroRepository libroRepository;

	@Override
	public Libro addLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	public List<Libro> getLibri() {
		return libroRepository.findAll();
	}

	@Override
	public Libro getLibro(int id) {
		return libroRepository.findById(id).get();
	}

	@Override
	public Libro updateLibro(Libro newLibro, Integer id) {
		Libro libro = libroRepository.findById(id).get();

		libro.setEditore_id(newLibro.getEditore_id());
		libro.setTitolo(newLibro.getTitolo());
		libro.setPagine(newLibro.getPagine());
		libro.setPrezzo(newLibro.getPrezzo());
		libro.setP_iva(newLibro.getP_iva());

		return libroRepository.save(libro);

	}

	@Override
	public void deleteLibro(int id) {
		libroRepository.deleteById(id);
	}
}
