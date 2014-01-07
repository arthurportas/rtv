package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IClientServiceTest {
	
	/*CRUD*/
	/**
	 * Given Client, persist it
	 * */
	public void create();
	/**
	 * Given Client id, find and delete it
	 * */
	public void delete();
	/**
	 * Given Client update it's persisted object
	 * */
	public void update();
	/**
	 * Given Client id, find and retrieve it
	 * */
	public void find();
	/**
	 * Fetch all Client entities from persistence
	 * */
	public void getAll();
	/**
	 * Count Client entities from persistence
	 * */
	public void count();
	/*DAO*/
	/**
	 * Fetch all Client entities from persistence, using a namedQuery
	 * */
	public void findAllClientsNamedQuery();
	/**
	 * Fetch all Client entities from persistence, using a namedQuery ??
	 * */
	public void findAllNamedQuery();
	/**
	 * ??
	 * */
	public void testClientHistory();
}
