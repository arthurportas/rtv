package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

public interface AnswerDao {
	
	/**
	 * 
	 * */
	public Answer findById(Long id);

	/**
	 * 
	 * */
	public Answer findByAnswer(String answer);

	/**
	 * 
	 * */
	public List<Answer> findAllOrderedByName();

	/**
	 * 
	 * */
	public void register(Answer answer);

	/**
	 * 
	 * */
	public Question setQuestionAssociation(Question question);
}
