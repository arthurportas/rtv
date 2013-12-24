/**
 * 
 */
package com.realtv.test.dao;

import java.util.List;

import com.realtv.domain.Answer;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface AnswerServiceTest {
	
	public void create();
	public void findAllAnswersNamedQuery();
	public void delete(Integer id);
	public Answer update(Answer answer);

	public Answer find(Integer id);

	public List<Answer> getAll();

	public List<Answer> findAllNamedQuery();
	
	public Long count();
}
