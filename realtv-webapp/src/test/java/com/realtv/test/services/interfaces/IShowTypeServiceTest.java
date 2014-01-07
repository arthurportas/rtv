package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IShowTypeServiceTest {
	
	/*CRUD*/
	/**
	 * Given ShowType, persist it
	 * */
	public void create();
	/**
	 * Given ShowType id, find and delete it
	 * */
	public void delete();
	/**
	 * Given ShowType update it's persisted object
	 * */
	public void update();
	/**
	 * Given ShowType id, find and retrieve it
	 * */
	public void find();
	/**
	 * Fetch all ShowType entities from persistence
	 * */
	public void getAll();
	/**
	 * Count ShowType entities from persistence
	 * */
	public void count();
	/*DAO*/
	/**
	 * Fetch all ShowType entities from persistence, using a namedQuery
	 * */
	public void findAllNamedQuery();
}
