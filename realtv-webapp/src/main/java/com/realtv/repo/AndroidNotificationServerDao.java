package com.realtv.repo;

import java.util.List;

import com.realtv.domain.AndroidNotificationServer;

public interface AndroidNotificationServerDao extends GenericDao<AndroidNotificationServer> {
	public List<AndroidNotificationServer> findAllNamedQuery();
}
