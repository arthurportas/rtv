/**
 * 
 */
package com.realtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Level;
import com.realtv.repo.LevelDao;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class LevelServiceImpl implements LevelService {

	@Autowired
	private LevelDao levelDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#create(com.realtv.domain.Level)
	 */
	@Override
	@Transactional(readOnly = false)
	public Level create(Level level) {
		return levelDao.create(level);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#delete(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		levelDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Level update(Level level) {
		return levelDao.update(level);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#find(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = false)
	public Level find(Long id) {
		return levelDao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Level> getAll() {
		return levelDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#count()
	 */
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return levelDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.AnswerService#findAllNamedQuery()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Level> findAllNamedQuery() {
		return levelDao.findAllNamedQuery();
	}
}
