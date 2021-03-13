package com.project.user.customer.repository.implementation;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.user.customer.model.models.ERole;
import com.project.user.customer.model.models.Role;

public interface IRolesRepos extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole name);

}