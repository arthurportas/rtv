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

import com.realtv.domain.Show;
import com.realtv.repo.ShowDao;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class ShowServiceImpl implements ShowService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowServiceImpl.class);
	
	@Autowired
	private ShowDao showDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#create(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Show create(Show show) {
		slf4jLogger.info("==Show create(Show show)==");
		return showDao.create(show);
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
		showDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Show update(Show show) {
		slf4jLogger.info("==Show update(Show show)==");
		return showDao.update(show);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#find(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Show find(Long id) {
		slf4jLogger.info("==Show find(Long id)==");
		return showDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Show> getAll() {
		slf4jLogger.info("==List<Show> getAll()==");
		return showDao.getAll();
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
		return showDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Show> findAllNamedQuery() {
		slf4jLogger.info("==List<Show> findAllNamedQuery()==");
		return showDao.findAllNamedQuery();
	}
}
