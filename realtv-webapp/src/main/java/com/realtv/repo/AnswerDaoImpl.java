package com.realtv.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.realtv.domain.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class AnswerDaoImpl extends GenericDaoImpl<Answer> implements AnswerDao {

	static final Logger LOG = LoggerFactory.getLogger(AnswerDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findAllNamedQuery() {
		LOG.debug("==List<Answer> findAllNamedQuery()==");
		return super.em.createNamedQuery(Answer.FIND_ALL).getResultList();
	}	
}
