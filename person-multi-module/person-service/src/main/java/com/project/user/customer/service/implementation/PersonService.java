package com.project.user.customer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.user.customer.domain.repository.IRepository;
import com.project.user.customer.model.models.Person;
import com.project.user.customer.repository.implementation.PersonIRepos;

@Service
public class PersonService extends AbstractService<Person, Integer> {

	@Autowired
	private PersonIRepos personRepos;

	@Override
	public IRepository<Person, Integer> getRepository() {
		return personRepos;
	}

}
