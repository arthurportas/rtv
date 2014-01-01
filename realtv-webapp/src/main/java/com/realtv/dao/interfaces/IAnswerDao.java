package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.Answer;

public interface IAnswerDao extends IGenericDao<Answer> {
	public List<Answer> findAllNamedQuery();
}
