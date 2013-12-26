/**
 * 
 */
package com.realtv.services;

import java.util.List;

import com.realtv.domain.Answer;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface AnswerService {
	public Answer create(Answer answer);

	public void delete(Long id);

	public Answer update(Answer answer);

	public Answer find(Long id);

	public List<Answer> getAll();

	public List<Answer> findAllNamedQuery();
	
	public Long count();
}
