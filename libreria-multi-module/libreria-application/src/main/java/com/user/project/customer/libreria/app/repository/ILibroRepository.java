package com.user.project.customer.libreria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.project.customer.libreria.app.model.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Integer> {

}
