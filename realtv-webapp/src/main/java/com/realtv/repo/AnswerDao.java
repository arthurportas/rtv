package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

public interface AnswerDao extends GenericDao<Answer> {
	public List<Answer> findAllNamedQuery();
	public Question setQuestionAssociation(Question question);
}
