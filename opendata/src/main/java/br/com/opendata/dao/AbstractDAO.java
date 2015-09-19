package br.com.opendata.dao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO<E> {

	private @Autowired
	SessionFactory sessionFactory;

	private Class<E> persistentClass;

	@PostConstruct
	private void sessionCreate() {
		persistentClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Criteria createCriteria() {

		Criteria criteria = getCurrentSession()
				.createCriteria(getEntityClass());

		return criteria;
	}

	public void save(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().save(object);			
		}
		getCurrentSession().flush();
	}

	public void update(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().update(object);
		}
	}

	public void delete(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().delete(object);
		}
	}

	public void evict(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().evict(object);
		}
	}

	protected Class<E> getEntityClass() {
		return persistentClass;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();

	}

}
