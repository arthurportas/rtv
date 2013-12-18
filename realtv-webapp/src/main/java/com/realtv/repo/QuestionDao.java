package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

public interface QuestionDao {
	
	/**
	 * @param id - id of Question to search for
	 * */
	public Question findById(Long id);

	/**
	 * @param question - question literal to search for
	 * */
	public Question findByQuestion(String question);

	/**
	 * @param question - question literal to search for
	 * @return {@link Question}
	 * */
	public Question findByQuestionNamedQuery(String question);
	
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
	 * Persist a question
	 * @param question
	 * */
	public void register(Question question);

	/**
	 * Persist an {@link List{@link Answer}} list
	 * 
	 * @param answers
	 * */
	public void registerAnswers(List<Answer> answers);

	/**
	 * Find all questions
	 * @return {@link List{@link Question}}
	 * */
	public List<Question> findAllQuestions();
	
	/**
	 * Find a {@link List{@link Answer}} by given literal question
	 * @param {@link List{@link Answer}}
	 * */
	public List<Answer> findAllAnswersByQuestion(String question);
}
