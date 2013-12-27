package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Answer;

public interface AnswerDao extends GenericDao<Answer> {
	public List<Answer> findAllNamedQuery();
}
