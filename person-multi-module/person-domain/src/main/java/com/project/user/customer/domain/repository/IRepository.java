package com.project.user.customer.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<T, R> extends JpaRepository<T, R> {

	List<T> findByIdIn(List<R> any);

}
