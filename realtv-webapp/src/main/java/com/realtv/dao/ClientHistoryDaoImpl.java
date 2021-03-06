package com.realtv.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IClientHistoryDao;
import com.realtv.domain.ClientHistory;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClientHistoryDaoImpl extends GenericDaoImpl<ClientHistory> implements IClientHistoryDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ClientHistoryDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientHistory> findAllNamedQuery() {
		slf4jLogger.info("==List<ClientHistory> findAllNamedQuery()==");
		return super.em.createNamedQuery(ClientHistory.FIND_ALL).getResultList();
	}
}
