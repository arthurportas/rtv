package com.realtv.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.domain.Show;

@Repository
public class ShowDaoImpl extends GenericDaoImpl<Show> implements ShowDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Show> findAllNamedQuery() {
		slf4jLogger.info("==List<Show> findAllNamedQuery()==");
		return super.em.createNamedQuery(Show.FIND_ALL).getResultList();
	}	
}
