package com.project.user.customer.model.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.project.user.customer.model.models.Person;
import com.project.user.customer.domain.dtomodel.IDTOModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonDTO implements IDTOModel<Integer> {
	private Integer id;
	private String fullName;
	private String email;
	private int phone;
	private String password;
	private List<AddressDTO> ads;

	public PersonDTO(Person person) {
		this.setId(person.getId());
		this.setFullName(person.getFName() + " " + person.getLName());
		this.setEmail(person.getEmail());
		this.setPhone(person.getPhone());
		this.setPassword(person.getPassword());
		List<AddressDTO> addressDTOs = person.getAds().stream().map(AddressDTO::new).collect(Collectors.toList());
		this.setAds(addressDTOs);
	}

}
