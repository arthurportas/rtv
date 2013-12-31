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

import com.realtv.domain.ShowType;
import com.realtv.repo.ShowTypeDao;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class ShowTypeServiceImpl implements ShowTypeService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowTypeServiceImpl.class);
	
	@Autowired
	private ShowTypeDao showTypeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#create(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public ShowType create(ShowType showType) {
		slf4jLogger.info("==ShowType create(ShowType showType)==");
		return showTypeDao.create(showType);
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
		showTypeDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public ShowType update(ShowType showType) {
		slf4jLogger.info("==ShowType update(ShowType showType)==");
		return showTypeDao.update(showType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#find(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public ShowType find(Long id) {
		slf4jLogger.info("==ShowType find(Long id)==");
		return showTypeDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ShowType> getAll() {
		slf4jLogger.info("==List<ShowType> getAll()==");
		return showTypeDao.getAll();
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
		return showTypeDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ShowType> findAllNamedQuery() {
		slf4jLogger.info("==List<ShowType> findAllNamedQuery()==");
		return showTypeDao.findAllNamedQuery();
	}
}
