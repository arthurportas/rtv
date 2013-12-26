package com.realtv.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class AnswerDaoImpl extends GenericDaoImpl<Answer> implements AnswerDao {

	static final Logger LOG = LoggerFactory.getLogger(AnswerDaoImpl.class);
	
	@Override
	public Question setQuestionAssociation(Question question) {
		LOG.debug("==Question setQuestionAssociation(Question question)==");
		em.persist(question);
		return question;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findAllNamedQuery() {
		LOG.debug("==List<Answer> findAllNamedQuery()==");
		return em.createNamedQuery(Answer.FIND_ALL).getResultList();
	}
}
