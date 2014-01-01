package com.realtv.repo;

import java.util.List;

import com.realtv.domain.ClientHistory;

public interface ClientHistoryDao extends GenericDao<ClientHistory> {
	public List<ClientHistory> findAllNamedQuery();
}
