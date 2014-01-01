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

import com.realtv.dao.interfaces.IAnswerDao;
import com.realtv.domain.Answer;
import com.realtv.services.interfaces.IAnswerService;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class AnswerServiceImpl implements IAnswerService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AnswerServiceImpl.class);
	
	@Autowired
	private IAnswerDao answerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#create(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Answer create(Answer answer) {
		slf4jLogger.info("==Answer create(Answer answer)==");
		return answerDao.create(answer);
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
		answerDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Answer update(Answer answer) {
		slf4jLogger.info("==Answer update(Answer answer)==");
		return answerDao.update(answer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#find(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Answer find(Long id) {
		slf4jLogger.info("==Answer find(Long id)==");
		return answerDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Answer> getAll() {
		slf4jLogger.info("==List<Answer> getAll()==");
		return answerDao.getAll();
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
		return answerDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Answer> findAllNamedQuery() {
		slf4jLogger.info("==List<Answer> findAllNamedQuery()==");
		return answerDao.findAllNamedQuery();
	}
}
