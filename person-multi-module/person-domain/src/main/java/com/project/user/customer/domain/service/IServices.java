package com.project.user.customer.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IServices<T, R> {
	T add(T t);

	T get(R id);

	List<T> getEvery();

	void delete(R id);

	T update(T T);

	List<T> find(List<R> integerList);

}
