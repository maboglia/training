package com.project.user.customer.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.project.user.customer.domain.model.IModel;
import com.project.user.customer.domain.repository.IRepository;
import com.project.user.customer.handler.DuplicatedException;
import com.project.user.customer.handler.IdNotFoundException;

@Service
public abstract class AbstractService<T extends IModel<R>, R> implements IServices<T, R> {

	@Override
	public T add(T t) {
		if (t.getId() != null && getRepository().existsById(t.getId())) {
			throw new DuplicatedException();
		}
		return getRepository().save(t);

	}

	@Override
	public T get(R id) {
		Optional<T> myT = (Optional<T>) getRepository().findById(id);
		if (myT.isEmpty()) {
			throw new IdNotFoundException();
		}
		return myT.get();
	}

	@Override
	public List<T> getEvery() {
		return (List<T>) getRepository().findAll();

	}

	@Override
	public void delete(R id) {
		getRepository().deleteById(id);

	}

	@Override
	public T update(T t) {
		return getRepository().save(t);
	}

	@Override
	public List<T> find(List<R> integerList) {
		return getRepository().findByIdIn(integerList);
	}

	public abstract IRepository<T, R> getRepository();

}
