/**
 * 
 */
package com.realtv.services;

import java.util.List;

import com.realtv.domain.ClientHistory;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface ClientHistoryService {
	
	public ClientHistory create(ClientHistory clientHistory);

	public void delete(Long id);

	public ClientHistory update(ClientHistory clientHistory);

	public ClientHistory find(Long id);

	public List<ClientHistory> getAll();

	public Long count();

	public List<ClientHistory> findAllNamedQuery();
}
