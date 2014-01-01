package com.realtv.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IAndroidNotificationServerDao;
import com.realtv.domain.AndroidNotificationServer;

@Repository
public class AndroidNotificationServerDaoImpl extends GenericDaoImpl<AndroidNotificationServer> implements IAndroidNotificationServerDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AndroidNotificationServerDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AndroidNotificationServer> findAllNamedQuery() {
		slf4jLogger.info("==List<AndroidNotificationServerDao> findAllNamedQuery()==");
		return super.em.createNamedQuery(AndroidNotificationServer.FIND_ALL).getResultList();
	}	
}
