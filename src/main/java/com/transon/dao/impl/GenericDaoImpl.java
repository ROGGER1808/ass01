package com.transon.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.transon.dao.IGenericDao;
import com.transon.utils.HibernateUtils;

public abstract class GenericDaoImpl<T> implements IGenericDao<T> {
	
	protected Class<? extends T> daoType;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType =  (Class<? extends T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public T findOne(String id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		T result = null;
		try {
			result =  session.get(daoType, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		List<T> results = null;
		try {
			results =  session.createQuery("from " + daoType.getName()).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return results;
	}

	@Override
	public void create(T entity) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T update(T entity) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		T result = null;
		try {
			tx = session.beginTransaction();
			result = (T) session.merge(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}

	@Override
	public void delete(T entity) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteById(String entityId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			T entity = findOne(entityId);
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<T> findByProperty(String property, Object value) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		List<T> results = null;
		try {
			Criteria criteria = session.createCriteria(daoType);
			results = criteria.add(Restrictions.eq(property, value)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return results;
	}
	
}
