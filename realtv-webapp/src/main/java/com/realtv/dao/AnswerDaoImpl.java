package com.realtv.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IAnswerDao;
import com.realtv.domain.Answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AnswerDaoImpl extends GenericDaoImpl<Answer> implements IAnswerDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AnswerDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findAllNamedQuery() {
		slf4jLogger.info("==List<Answer> findAllNamedQuery()==");
		return super.em.createNamedQuery(Answer.FIND_ALL).getResultList();
	}
}
