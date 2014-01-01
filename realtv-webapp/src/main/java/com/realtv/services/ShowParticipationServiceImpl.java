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

import com.realtv.dao.interfaces.IShowParticipationDao;
import com.realtv.domain.ShowParticipation;
import com.realtv.services.interfaces.IShowParticipationService;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class ShowParticipationServiceImpl implements IShowParticipationService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowParticipationServiceImpl.class);
	
	@Autowired
	private IShowParticipationDao ShowParticipationDao;

	@Override
	@Transactional(readOnly = false)
	public ShowParticipation create(ShowParticipation showParticipation) {
		slf4jLogger.info("==ShowParticipation create(ShowParticipation showParticipation)==");
		return ShowParticipationDao.create(showParticipation);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		slf4jLogger.info("==void delete(Long id)==");
		ShowParticipationDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.services.AnswerService#update(com.realtv.domain.Answer)
	 */
	@Override
	@Transactional(readOnly = false)
	public ShowParticipation update(ShowParticipation showParticipation) {
		slf4jLogger.info("==ShowParticipation update(ShowParticipation showParticipation)==");
		return ShowParticipationDao.update(showParticipation);
	}

	@Override
	@Transactional(readOnly = false)
	public ShowParticipation find(Long id) {
		slf4jLogger.info("==ShowParticipation find(Long id)==");
		return ShowParticipationDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShowParticipation> getAll() {
		slf4jLogger.info("==List<ShowParticipation> getAll()==");
		return ShowParticipationDao.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		slf4jLogger.info("==Long count()==");
		return ShowParticipationDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShowParticipation> findAllNamedQuery() {
		slf4jLogger.info("==List<ShowParticipation> findAllNamedQuery()==");
		return ShowParticipationDao.findAllNamedQuery();
	}
}
