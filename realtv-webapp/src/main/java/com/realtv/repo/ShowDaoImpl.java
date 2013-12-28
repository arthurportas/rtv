package com.realtv.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.domain.Show;

@Repository
public class ShowDaoImpl extends GenericDaoImpl<Show> implements ShowDao {

	static final Logger LOG = LoggerFactory.getLogger(ShowDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Show> findAllNamedQuery() {
		LOG.debug("==List<Show> findAllNamedQuery()==");
		return super.em.createNamedQuery(Show.FIND_ALL).getResultList();
	}	
}
