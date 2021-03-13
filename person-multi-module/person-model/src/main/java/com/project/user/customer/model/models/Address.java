package com.project.user.customer.model.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.user.customer.domain.model.IModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "address")
public class Address implements IModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, length = 10)
	private Integer id;

	@Column(name = "city_name", nullable = false, length = 10)
	private String city;

	@Column(name = "street_name", nullable = false, length = 10)
	private String street;

	@Column(name = "house_number", nullable = false, length = 10)
	private int hNumber;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "people_Id", nullable = false)
	private Person person;

}
