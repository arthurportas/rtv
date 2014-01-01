package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.ClientHistory;

public interface IClientHistoryDao extends IGenericDao<ClientHistory> {
	public List<ClientHistory> findAllNamedQuery();
}
