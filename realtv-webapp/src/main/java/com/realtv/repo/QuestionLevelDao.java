package com.realtv.repo;

import java.util.List;

import com.realtv.domain.QuestionLevel;

public interface QuestionLevelDao extends GenericDao<QuestionLevel> {
	public List<QuestionLevel> findAllNamedQuery();
}
