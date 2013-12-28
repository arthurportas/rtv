package com.realtv.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.realtv.domain.Answer;
import com.realtv.domain.ShowType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class ShowTypeDaoImpl extends GenericDaoImpl<ShowType> implements ShowTypeDao {

	static final Logger LOG = LoggerFactory.getLogger(ShowTypeDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowType> findAllNamedQuery() {
		LOG.debug("==List<ShowType> findAllNamedQuery()==");
		return super.em.createNamedQuery(Answer.FIND_ALL).getResultList();
	}	
}
