package com.realtv.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.domain.ClientHistory;

@Repository
public class ClientHistoryDaoImpl extends GenericDaoImpl<ClientHistory> implements ClientHistoryDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ClientHistoryDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientHistory> findAllNamedQuery() {
		slf4jLogger.info("==List<ClientHistory> findAllNamedQuery()==");
		return super.em.createNamedQuery(ClientHistory.FIND_ALL).getResultList();
	}	
}
