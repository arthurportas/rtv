package com.realtv.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IShowDao;
import com.realtv.domain.Show;

@Repository
public class ShowDaoImpl extends GenericDaoImpl<Show> implements IShowDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Show> findAllNamedQuery() {
		slf4jLogger.info("==List<Show> findAllNamedQuery()==");
		return super.em.createNamedQuery(Show.FIND_ALL).getResultList();
	}	
}
