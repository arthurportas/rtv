/**
 * 
 */
package com.realtv.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.dao.interfaces.IAndroidNotificationServerDao;
import com.realtv.domain.AndroidNotificationServer;
import com.realtv.services.interfaces.IAndroidNotificationServerService;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class AndroidNotificationServerServiceImpl implements IAndroidNotificationServerService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AndroidNotificationServerServiceImpl.class);
	
	@Autowired
	private IAndroidNotificationServerDao androidNotificationServerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#create(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public AndroidNotificationServer create(AndroidNotificationServer androidNotificationServer) {
		slf4jLogger.info("==AndroidNotificationServer create(AndroidNotificationServer androidNotificationServer)==");
		return androidNotificationServerDao.create(androidNotificationServer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#delete(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		slf4jLogger.info("==void delete(Long id)==");
		androidNotificationServerDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public AndroidNotificationServer update(AndroidNotificationServer androidNotificationServer) {
		slf4jLogger.info("==AndroidNotificationServer update(AndroidNotificationServer androidNotificationServer)==");
		return androidNotificationServerDao.update(androidNotificationServer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#find(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public AndroidNotificationServer find(Long id) {
		slf4jLogger.info("==AndroidNotificationServer find(Long id)==");
		return androidNotificationServerDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AndroidNotificationServer> getAll() {
		slf4jLogger.info("==List<AndroidNotificationServer> getAll()==");
		return androidNotificationServerDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#count()
	 */
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		slf4jLogger.info("==Long count()==");
		return androidNotificationServerDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AndroidNotificationServer> findAllNamedQuery() {
		slf4jLogger.info("==List<AndroidNotificationServer> findAllNamedQuery()==");
		return androidNotificationServerDao.findAllNamedQuery();
	}
}
