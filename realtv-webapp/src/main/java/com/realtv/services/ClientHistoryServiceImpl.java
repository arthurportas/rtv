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

import com.realtv.dao.interfaces.IClientHistoryDao;
import com.realtv.domain.ClientHistory;
import com.realtv.services.interfaces.IClientHistoryService;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class ClientHistoryServiceImpl implements IClientHistoryService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ClientHistoryServiceImpl.class);
	
	@Autowired
	private IClientHistoryDao clientHistoryDao;

	@Override
	@Transactional(readOnly = false)
	public ClientHistory create(ClientHistory clientHistory) {
		slf4jLogger.info("==ClientHistory create(ClientHistory clientHistory)==");
		return clientHistoryDao.create(clientHistory);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		slf4jLogger.info("==void delete(Long id)==");
		clientHistoryDao.delete(id);
	}

	@Override
	@Transactional(readOnly = false)
	public ClientHistory update(ClientHistory clientHistory) {
		slf4jLogger.info("==ClientHistory update(ClientHistory clientHistory)==");
		return clientHistoryDao.update(clientHistory);
	}

	@Override
	@Transactional(readOnly = false)
	public ClientHistory find(Long id) {
		slf4jLogger.info("==ClientHistory find(Long id)==");
		return clientHistoryDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientHistory> getAll() {
		slf4jLogger.info("==List<ClientHistory> getAll()==");
		return clientHistoryDao.getAll();
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
		return clientHistoryDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ClientHistory> findAllNamedQuery() {
		slf4jLogger.info("==List<ClientHistory> findAllNamedQuery()==");
		return clientHistoryDao.findAllNamedQuery();
	}
}
