package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Client;

public interface ClientDao extends GenericDao<Client> {
	public List<Client> findAllNamedQuery();
}
