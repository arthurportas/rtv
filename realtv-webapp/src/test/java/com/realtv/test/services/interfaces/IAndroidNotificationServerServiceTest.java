package com.realtv.test.services.interfaces;



/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IAndroidNotificationServerServiceTest {
	
	/*CRUD*/
	public void create();
	public void delete();
	public void update();
	public void find();
	public void getAll();
	public void count();
	/*DAO*/
	public void findAllAndroidNotificationServersNamedQuery();
	public void findAllNamedQuery();
	/*JPA*/
	public void testClientAssociation();
}
