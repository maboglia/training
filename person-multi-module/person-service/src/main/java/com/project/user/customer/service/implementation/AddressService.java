package com.project.user.customer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.user.customer.model.models.Address;
import com.project.user.customer.repository.implementation.IAddressRepos;

@Service
public class AddressService extends AbstractService<Address, Integer> {
	
	@Autowired
	private IAddressRepos addressRepos;

	@Override
	public IAddressRepos getRepository() {
		return addressRepos;
	}

}
