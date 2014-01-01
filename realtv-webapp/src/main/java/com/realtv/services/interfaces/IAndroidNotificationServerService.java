/**
 * 
 */
package com.realtv.services.interfaces;

import java.util.List;

import com.realtv.domain.AndroidNotificationServer;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IAndroidNotificationServerService {
	
	public AndroidNotificationServer create(AndroidNotificationServer androidNotificationServer);

	public void delete(Long id);

	public AndroidNotificationServer update(AndroidNotificationServer androidNotificationServer);

	public AndroidNotificationServer find(Long id);

	public List<AndroidNotificationServer> getAll();

	public Long count();

	public List<AndroidNotificationServer> findAllNamedQuery();
}
