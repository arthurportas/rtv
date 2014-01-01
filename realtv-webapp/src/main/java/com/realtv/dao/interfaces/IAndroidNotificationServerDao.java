package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.AndroidNotificationServer;

public interface IAndroidNotificationServerDao extends IGenericDao<AndroidNotificationServer> {
	public List<AndroidNotificationServer> findAllNamedQuery();
}
