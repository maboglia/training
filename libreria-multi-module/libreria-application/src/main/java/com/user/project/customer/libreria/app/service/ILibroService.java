package com.user.project.customer.libreria.app.service;

import java.util.List;
import com.user.project.customer.libreria.app.model.Libro;

public interface ILibroService {

	Libro addLibro(Libro l);

	List<Libro> getLibri();

	Libro getLibro(int id);

	void deleteLibro(int id);

	Libro updateLibro(Libro l, Integer id);

}
