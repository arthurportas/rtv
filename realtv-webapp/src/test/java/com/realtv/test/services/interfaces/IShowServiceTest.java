package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IShowServiceTest {
	
	/*CRUD*/
	/**
	 * Given Show, persist it
	 * */
	public void create();
	/**
	 * Given Show id, find and delete it
	 * */
	public void delete();
	/**
	 * Given Show update it's persisted object
	 * */
	public void update();
	/**
	 * Given Show id, find and retrieve it
	 * */
	public void find();
	/**
	 * Fetch all Show entities from persistence
	 * */
	public void getAll();
	/**
	 * Count Show entities from persistence
	 * */
	public void count();
	/*DAO*/
	/**
	 * Fetch all Show entities from persistence, using a namedQuery
	 * */
	public void findAllNamedQuery();
	/**
	 * Persist a Show entity, using a nativeQuery
	 * */
	public void insertShowNativeQuery();
	/**
	 * Given Show, find it's clients history
	 * */
	public void  getClientHistory();
	/*Multi entities queries*/
	/**
	 * Fetch all Show entities in demo mode from persistence, using a nativeQuery declared in 'queries.properties'
	 * */
	public void showAllDemoShowNativeQuery();
	/**
	 * Fetch all Show entities in real-time mode from persistence, using a nativeQuery declared in 'queries.properties'
	 * */
	public void showAllRealTimeShowNativeQuery();
	/**
	 * Fetch all Show entities filtered by ShowType from persistence, using a namedQuery
	 * */
	public void findByShowTypeNamedQuery();
}
