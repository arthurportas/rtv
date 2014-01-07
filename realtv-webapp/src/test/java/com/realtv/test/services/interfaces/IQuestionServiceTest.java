package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IQuestionServiceTest {
	
	/*CRUD*/
	/**
	 * Given Question, persist it
	 * */
	public void create();
	/**
	 * Given Question id, find and delete it
	 * */
	public void delete();
	/**
	 * Given Question update it's persisted object
	 * */
	public void update();
	/**
	 * Given Question id, find and retrieve it
	 * */
	public void find();
	/**
	 * Fetch all Question entities from persistence
	 * */
	public void getAll();
	/**
	 * Count Question entities from persistence
	 * */
	public void count();
	/*DAO*/
	/**
	 * Fetch all Question entities from persistence, ordered by name ASC
	 * */
	public void findAllOrderedByName();
	/**
	 * Fetch all Answers for given Question 
	 * */
	public void findAnswersByQuestionNamedQuery();
	/**
	 * Fetch Question from persistence, given question match as String
	 * */
	public void findQuestionNamedQuery();
	/**
	 * Associate Answer List to given Question
	 * */
	public void registerAnswers();
	/**
	 * Associate QuestionLevel to given Question
	 * */
	public void registerQuestionLevel();
	/**
	 * Given Question, find it's available time to answer
	 * */
	public void getTimeToAnswer();
	/**
	 * Given Question, find it's dificulty level
	 * */
	public void getDificultyLevel();
	/**
	 * Given Question, find it's answers
	 * */
	public void getAnswers();
	
}
