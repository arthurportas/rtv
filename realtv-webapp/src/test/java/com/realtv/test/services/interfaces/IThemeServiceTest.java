package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IThemeServiceTest {
	
	/*CRUD*/
	/**
	 * Given Theme, persist it
	 * */
	public void create();
	/**
	 * Given Theme id, find and delete it
	 * */
	public void delete();
	/**
	 * Given Theme update it's persisted object
	 * */
	public void update();
	/**
	 * Given Theme id, find and retrieve it
	 * */
	public void find();
	/**
	 * Fetch all Theme entities from persistence
	 * */
	public void getAll();
	/**
	 * Count Theme entities from persistence
	 * */
	public void count();
	/*DAO*/
	/**
	 * Fetch all Theme entities from persistence, ordered by name ASC
	 * */
	public void findAllOrderedByName();
	/**
	 * Given theme as String, find and retrieve it
	 * */
	public void findByTheme();
}
