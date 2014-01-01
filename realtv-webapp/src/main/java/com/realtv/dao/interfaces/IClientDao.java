package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.Client;

public interface IClientDao extends IGenericDao<Client> {
	public List<Client> findAllNamedQuery();
}
