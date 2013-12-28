package com.realtv.test.services;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface ShowServiceTest {
	
	/*CRUD*/
	public void create();
	public void delete();
	public void update();
	public void find();
	public void getAll();
	public void count();
	/*DAO*/
	public void findAllNamedQuery();
	public void insertShowNativeQuery();
}
