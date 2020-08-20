package com.transon.service.impl;

import java.util.List;

import com.transon.dao.IGenericDao;
import com.transon.service.IGenericService;

public abstract class GenericServiceImpl<T> implements IGenericService<T> {
	private IGenericDao<T> genericDao;

	public GenericServiceImpl() {
		super();
	}

	public GenericServiceImpl(IGenericDao<T> genericDao) {
		super();
		this.genericDao = genericDao;
	}

	public IGenericDao<T> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(IGenericDao<T> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public T findOne(String id) {
		return genericDao.findOne(id);
	}

	@Override
	public List<T> findAll() {
		return genericDao.findAll();
	}

	@Override
	public void create(T entity) {
		genericDao.create(entity);
	}

	@Override
	public T update(T entity) {
		return genericDao.update(entity);
	}

	@Override
	public void delete(T entity) {
		genericDao.delete(entity);
	}

	@Override
	public void deleteById(String entityId) {
		genericDao.deleteById(entityId);
	}

	@Override
	public List<T> findByProperty(String property, Object value) {
		return genericDao.findByProperty(property, value);
	}
}
