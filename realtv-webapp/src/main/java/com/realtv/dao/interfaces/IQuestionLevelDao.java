package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.QuestionLevel;

public interface IQuestionLevelDao extends IGenericDao<QuestionLevel> {
	public List<QuestionLevel> findAllNamedQuery();
}
