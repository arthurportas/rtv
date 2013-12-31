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
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(GenericDaoImpl.class);

	private Class<T> type;
	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		slf4jLogger.info("==GenericDaoImpl()==");
		Type t = getClass().getGenericSuperclass();
		slf4jLogger.debug("==Type t==" + t);
		ParameterizedType pt = (ParameterizedType) t;
		slf4jLogger.debug("==ParameterizedType pt==" + pt);
		type = (Class<T>) pt.getActualTypeArguments()[0];
		slf4jLogger.debug("==Class<T> type==" + type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#count()
	 */
	@Override
	public long count() {
		slf4jLogger.info("==long count()==");
		String entity = type.getSimpleName();
		slf4jLogger.debug("==entity==" + entity);
		final StringBuffer queryString = new StringBuffer(
				"select count(ent) from " + entity + " ent");
		final Query query = this.em.createQuery(queryString.toString());
		slf4jLogger.debug("==query==" + queryString.toString());
		return (Long) query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#create(java.io.Serializable)
	 */
	@Override
	public T create(final T entity) {
		slf4jLogger.info("==T create(final T entity)==");
		Preconditions.checkNotNull(entity);
		em.persist(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(final long entityId) {
		slf4jLogger.info("==void delete(final long entityId)==");
		final T entity = find(entityId);
		Preconditions.checkState(entity != null);
		em.remove(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#find(java.lang.Object)
	 */
	@Override
	public T find(final long id) {
		slf4jLogger.info("==T find(final long id)==");
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
		slf4jLogger.info("==List<T> getAll()==");
		Query query = em.createQuery("from " + type.getName());
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.GenericDao#update(java.io.Serializable)
	 */
	@Override
	public T update(final T entity) {
		slf4jLogger.info("==T update(final T entity)==");
		Preconditions.checkNotNull(entity);
		return em.merge(entity);
	}

}
