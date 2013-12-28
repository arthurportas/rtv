package com.realtv.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.domain.Level;

@Repository
public class LevelDaoImpl extends GenericDaoImpl<Level> implements LevelDao {

	static final Logger LOG = LoggerFactory.getLogger(LevelDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Level> findAllNamedQuery() {
		LOG.debug("==List<Level> findAllNamedQuery()==");
		return super.em.createNamedQuery(Level.FIND_ALL).getResultList();
	}	
}
