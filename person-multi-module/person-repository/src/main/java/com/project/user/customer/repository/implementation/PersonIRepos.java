package com.project.user.customer.repository.implementation;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.project.user.customer.domain.repository.IRepository;
import com.project.user.customer.model.models.Person;

@Repository
public interface PersonIRepos extends IRepository<Person, Integer> {

	Optional<Person> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}