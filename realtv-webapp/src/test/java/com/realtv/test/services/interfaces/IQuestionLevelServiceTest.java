package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IQuestionLevelServiceTest {
	
	/*CRUD*/
	/**
	 * Given QuestionLevel, persist it
	 * */
	public void create();
	/**
	 * Given QuestionLevel id, find and delete it
	 * */
	public void delete();
	/**
	 * Given QuestionLevel update it's persisted object
	 * */
	public void update();
	/**
	 * Given QuestionLevel id, find and retrieve it
	 * */
	public void find();
	/**
	 * Fetch all QuestionLevel entities from persistence
	 * */
	public void getAll();
	/**
	 * Count QuestionLevel entities from persistence
	 * */
	public void count();
	/*DAO*/
	/**
	 * Fetch all QuestionLevel entities from persistence, using a namedQuery
	 * */
	public void findAllNamedQuery();
}
