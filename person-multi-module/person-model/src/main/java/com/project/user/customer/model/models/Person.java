package com.project.user.customer.model.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.user.customer.domain.model.IModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "people", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class Person implements IModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, length = 10)
	private Integer id;

	@Column(name = "First_Name", length = 60)
	private String fName;

	@Column(name = "Last_Name", length = 60)
	private String lName;

	@Column(name = "Username", nullable = false, length = 60)
	private String username;

	@Email
	@Column(name = "Email", nullable = false, length = 100)
	private String email;

	@Column(name = "Mobile_Phone_Number", length = 11)
	private int phone;

	@Column(name = "Password", nullable = false)
	private String password;

	@JsonManagedReference
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "Address", nullable = false, length = 25)
	private List<Address> ads;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "User_Roles", joinColumns = @JoinColumn(name = "User_Id"), inverseJoinColumns = @JoinColumn(name = "Role_Id"))
	private Set<Role> roles = new HashSet<>();

	public Person(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
