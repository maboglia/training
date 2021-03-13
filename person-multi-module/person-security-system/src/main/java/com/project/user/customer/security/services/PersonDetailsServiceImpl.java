package com.project.user.customer.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.user.customer.model.models.Person;
import com.project.user.customer.repository.implementation.PersonIRepos;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	PersonIRepos personRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return PersonDetailsImpl.build(person);
	}

}