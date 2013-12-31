package com.realtv.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.domain.Client;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ClientDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAllNamedQuery() {
		slf4jLogger.info("==List<Client> findAllNamedQuery()==");
		return super.em.createNamedQuery(Client.FIND_ALL).getResultList();
	}	
}
