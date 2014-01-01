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

import com.realtv.dao.interfaces.IQuestionLevelDao;
import com.realtv.domain.QuestionLevel;
import com.realtv.services.interfaces.IQuestionLevelService;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class QuestionLevelServiceImpl implements IQuestionLevelService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(QuestionLevelServiceImpl.class);
	
	@Autowired
	private IQuestionLevelDao questionLevelDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#create(com.realtv.domain.Level)
	 */
	@Override
	@Transactional(readOnly = false)
	public QuestionLevel create(QuestionLevel questionLevel) {
		slf4jLogger.info("==QuestionLevel create(QuestionLevel questionLevel)==");
		return questionLevelDao.create(questionLevel);
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
		questionLevelDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public QuestionLevel update(QuestionLevel questionLevel) {
		slf4jLogger.info("==QuestionLevel update(QuestionLevel questionLevel)==");
		return questionLevelDao.update(questionLevel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#find(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public QuestionLevel find(Long id) {
		slf4jLogger.info("==QuestionLevel find(Long id)==");
		return questionLevelDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<QuestionLevel> getAll() {
		slf4jLogger.info("==List<QuestionLevel> getAll()==");
		return questionLevelDao.getAll();
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
		return questionLevelDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<QuestionLevel> findAllNamedQuery() {
		slf4jLogger.info("==questionLevelDao.findAllNamedQuery()==");
		return questionLevelDao.findAllNamedQuery();
	}
}
