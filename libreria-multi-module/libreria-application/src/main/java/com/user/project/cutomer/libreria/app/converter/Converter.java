package com.user.project.cutomer.libreria.app.converter;

import com.user.project.customer.libreria.app.model.Libro;
import com.user.project.customer.libreria.dtomodel.DTOLibro;

public class Converter {

	public static Libro toModel(DTOLibro dto) {
		Libro libro = new Libro();
		libro.setId(dto.getEditore_id());
		libro.setTitolo(dto.getTitolo());
		libro.setEditore_id(dto.getEditore_id());
		libro.setPagine(dto.getPagine());
		libro.setPrezzo(dto.getPrezzo());
		libro.setP_iva(dto.getP_iva());
		return libro;
	}

	public static DTOLibro toDTO(Libro libro) {
		DTOLibro dto = new DTOLibro();
		dto.setId(libro.getId());
		dto.setTitolo(libro.getTitolo());
		dto.setEditore_id(libro.getEditore_id());
		dto.setPagine(libro.getPagine());
		dto.setPrezzo(dto.getPrezzo());
		dto.setP_iva(libro.getP_iva());
		return dto;
	}
	
}
