package com.transon.service;

import java.util.List;

public interface IGenericService<T> {
	T findOne(final String id);
	List<T> findAll();
	void create(final T entity);
	T update(final T entity);
	void delete(final T entity);
	void deleteById(final String entityId);
	List<T> findByProperty(String property, Object value);
}
