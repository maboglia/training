package com.project.user.customer.model.dto;

import com.project.user.customer.model.models.Address;
import com.project.user.customer.domain.dtomodel.IDTOModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddressDTO implements IDTOModel<Integer> {
	private Integer id;
	private String city;
	private String street;
	private int hNumber;
	private PersonDTO person;

	public AddressDTO(Address address) {
		this.setId(address.getId());
		this.setCity(address.getCity());
		this.setStreet(address.getStreet());
		this.setHNumber(address.getHNumber());
	}

}