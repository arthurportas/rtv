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

import com.realtv.dao.interfaces.IQuestionDao;
import com.realtv.domain.Answer;
import com.realtv.domain.Question;
import com.realtv.services.interfaces.IQuestionService;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class QuestionServiceImpl implements IQuestionService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(QuestionServiceImpl.class);
	
	@Autowired
	private IQuestionDao questionDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.services.QuestionService#create(com.realtv.domain.Question)
	 */
	@Override
	@Transactional(readOnly = false)
	public Question create(Question question) {
		slf4jLogger.info("==Question create(Question question)==");
		return questionDao.create(question);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.QuestionService#delete(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		slf4jLogger.info("==void delete(Long id)==");
		questionDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.services.QuestionService#update(com.realtv.domain.Question)
	 */
	@Override
	@Transactional(readOnly = false)
	public Question update(Question question) {
		slf4jLogger.info("==Question update(Question question)==");
		return questionDao.update(question);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.QuestionService#find(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = false)
	public Question find(Long id) {
		slf4jLogger.info("==Question find(Long id)==");
		return questionDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.QuestionService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Question> getAll() {
		slf4jLogger.info("==List<Question> getAll()==");
		return questionDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.QuestionService#count()
	 */
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		slf4jLogger.info("==Long count()==");
		return questionDao.count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.services.QuestionService#findQuestionNamedQuery(java.lang.
	 * String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Question findQuestionNamedQuery(String question) {
		slf4jLogger.info("==Question findQuestionNamedQuery(String question)==");
		return questionDao.findQuestionNamedQuery(question);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.services.QuestionService#findAnswersByQuestionNamedQuery(java
	 * .lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Answer> findAnswersByQuestionNamedQuery(String question) {
		slf4jLogger.info("==List<Answer> findAnswersByQuestionNamedQuery(String question)==");
		return questionDao.findAnswersByQuestionNamedQuery(question);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.QuestionService#findAllOrderedByName()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Question> findAllOrderedByName() {
		slf4jLogger.info("==List<Question> findAllOrderedByName()==");
		return questionDao.findAllOrderedByName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.services.QuestionService#registerAnswers(com.realtv.domain
	 * .Question, java.util.List)
	 */
	@Override
	@Transactional(readOnly = true)
	public void registerAnswers(Question question, List<Answer> answers) {
		slf4jLogger.info("==void registerAnswers(Question question, List<Answer> answers)==");
		questionDao.registerAnswers(question, answers);
	}
}
