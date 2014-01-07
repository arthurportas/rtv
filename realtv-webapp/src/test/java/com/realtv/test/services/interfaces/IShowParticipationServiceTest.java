package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IShowParticipationServiceTest {
	
	/*CRUD*/
	/**
	 * Given ShowParticipation, persist it
	 * */
	public void create();
	/**
	 * Given ShowParticipation id, find and delete it
	 * */
	public void delete();
	/**
	 * Given ShowParticipation update it's persisted object
	 * */
	public void update();
	/**
	 * Given ShowParticipation id, find and retrieve it
	 * */
	public void find();
	/**
	 * Fetch all ShowParticipation entities from persistence
	 * */
	public void getAll();
	/**
	 * Count ShowParticipation entities from persistence
	 * */
	public void count();
	/*DAO*/
	/**
	 * Fetch all ShowParticipation entities from persistence, using a namedQuery
	 * */
	public void findAllNamedQuery();
	/**
	 * Persist ShowParticipation entity, using a nativeQuery
	 * */
	public void insertShowParticipationNativeQuery();
}
