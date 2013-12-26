/**
 * 
 */
package com.realtv.repo;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

	static final Logger LOG = LoggerFactory.getLogger(GenericDaoImpl.class);
	
	private Class<T> type;
	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		LOG.debug("==GenericDaoImpl()==");
		Type t = getClass().getGenericSuperclass();
		LOG.debug("==Type t==" + t);
		ParameterizedType pt = (ParameterizedType) t;
		LOG.debug("==ParameterizedType pt==" + pt);
		type = (Class<T>) pt.getActualTypeArguments()[0];
		LOG.debug("==Class<T> type==" + type);	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#count()
	 */
	@Override
	public long count() {
		LOG.debug("==long count()==");	
		String entity = type.getSimpleName();
		LOG.debug("==entity==" + entity);
		final StringBuffer queryString = new StringBuffer(
				"select count(ent) from " + entity + " ent");
		final Query query = this.em.createQuery(queryString.toString());
		LOG.debug("==query==" + queryString.toString());	
		return (Long) query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#create(java.io.Serializable)
	 */
	@Override
	public T create(final T t) {
		LOG.debug("==T create(final T t)==");
		em.persist(t);
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(final Object id) {
		LOG.debug("==void delete(final Object id)==");
		em.remove(em.getReference(type, id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#find(java.lang.Object)
	 */
	@Override
	public T find(final Object id) {
		LOG.debug("==T find(final Object id)==");
		return em.find(type, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#getAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		LOG.debug("==List<T> getAll()==");
		Query query = em.createQuery("from " + type.getName());
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#update(java.io.Serializable)
	 */
	@Override
	public T update(final T t) {
		LOG.debug("==T update(final T t)==");
		return em.merge(t);
	}

}
