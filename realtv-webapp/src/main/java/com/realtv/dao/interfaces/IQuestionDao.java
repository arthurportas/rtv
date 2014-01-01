package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

public interface IQuestionDao extends IGenericDao<Question>{

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
	 * Persist an {@link List{@link Answer}} list
	 * 
	 * @param answers
	 * */
	public void registerAnswers(Question question, List<Answer> answers);
	
}
