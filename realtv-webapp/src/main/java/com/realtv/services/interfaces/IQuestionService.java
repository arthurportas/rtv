/**
 * 
 */
package com.realtv.services.interfaces;

import java.util.List;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IQuestionService {
	
	public Question create(Question question);

	public void delete(Long id);

	public Question update(Question question);

	public Question find(Long id);

	public List<Question> getAll();
	
	public Long count();
	
	/**
	 * @param question - question literal to search for
	 * @return {@link Question}
	 * */
	public Question findQuestionNamedQuery(String question);
	
	/**
	 * @param question - question literal to search for
	 * @return {@link List{@link Answer}}
	 * */
	public List<Answer> findAnswersByQuestionNamedQuery(String question);
	
	/**
	 * Find all questions ordered by name asc
	 * @return {@link List{@link Question}}
	 * */
	public List<Question> findAllOrderedByName();

	/**
	 * Persist a {@link Answer} list
	 * 
	 * @param question - Question to associate answers
	 * @param answers - Answer list to associate to question
	 * */
	public void registerAnswers(Question question, List<Answer> answers);
}
