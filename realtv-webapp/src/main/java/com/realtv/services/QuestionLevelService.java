/**
 * 
 */
package com.realtv.services;

import java.util.List;

import com.realtv.domain.QuestionLevel;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface QuestionLevelService {

	public QuestionLevel create(QuestionLevel questionLevel);

	public void delete(Long id);

	public QuestionLevel update(QuestionLevel questionLevel);

	public QuestionLevel find(Long id);

	public List<QuestionLevel> getAll();

	public Long count();

	public List<QuestionLevel> findAllNamedQuery();
}
