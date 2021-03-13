package com.project.user.customer.repository.implementation;

import org.springframework.stereotype.Repository;
import com.project.user.customer.domain.repository.IRepository;
import com.project.user.customer.model.models.Address;

@Repository
public interface IAddressRepos extends IRepository<Address, Integer> {

}
