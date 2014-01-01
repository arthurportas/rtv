package com.realtv.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IShowParticipationDao;
import com.realtv.domain.ShowParticipation;

@Repository
public class ShowParticipationDaoImpl extends GenericDaoImpl<ShowParticipation> implements IShowParticipationDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowParticipationDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowParticipation> findAllNamedQuery() {
		slf4jLogger.info("==List<ShowParticipation> findAllNamedQuery()==");
		return super.em.createNamedQuery(ShowParticipation.FIND_ALL).getResultList();
	}	
}
