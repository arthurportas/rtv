package com.realtv.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IShowTypeDao;
import com.realtv.domain.Answer;
import com.realtv.domain.ShowType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ShowTypeDaoImpl extends GenericDaoImpl<ShowType> implements IShowTypeDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowTypeDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowType> findAllNamedQuery() {
		slf4jLogger.info("==List<ShowType> findAllNamedQuery()==");
		return super.em.createNamedQuery(Answer.FIND_ALL).getResultList();
	}	
}
