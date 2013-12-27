/**
 * 
 */
package com.realtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;
import com.realtv.repo.QuestionDao;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.services.QuestionService#create(com.realtv.domain.Question)
	 */
	@Override
	@Transactional(readOnly = false)
	public Question create(Question question) {
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
		questionDao.registerAnswers(question, answers);
	}
}
