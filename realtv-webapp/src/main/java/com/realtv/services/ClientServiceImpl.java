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

import com.realtv.domain.Client;
import com.realtv.repo.ClientDao;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Autowired
	private ClientDao clientDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#create(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Client create(Client client) {
		slf4jLogger.info("==Client create(Client client)==");
		return clientDao.create(client);
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
		clientDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Client update(Client client) {
		slf4jLogger.info("==Client update(Client client)==");
		return clientDao.update(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#find(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Client find(Long id) {
		slf4jLogger.info("==Client find(Long id)==");
		return clientDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> getAll() {
		slf4jLogger.info("==List<Client> getAll()==");
		return clientDao.getAll();
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
		return clientDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAllNamedQuery() {
		slf4jLogger.info("==List<Client> findAllNamedQuery()==");
		return clientDao.findAllNamedQuery();
	}
}
