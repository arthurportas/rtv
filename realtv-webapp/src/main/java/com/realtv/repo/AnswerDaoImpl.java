package com.realtv.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

@Repository
public class AnswerDaoImpl extends GenericDaoImpl<Answer> implements AnswerDao {

	@Override
	public Question setQuestionAssociation(Question question) {
		em.persist(question);
		return question;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findAllNamedQuery() {
		return em.createNamedQuery(Answer.FIND_ALL).getResultList();
	}
}
