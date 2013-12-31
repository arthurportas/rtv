/**
 * 
 */
package com.realtv.services;

import java.util.List;

import com.realtv.domain.Client;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface ClientService {
	
	public Client create(Client client);

	public void delete(Long id);

	public Client update(Client client);

	public Client find(Long id);

	public List<Client> getAll();

	public Long count();

	public List<Client> findAllNamedQuery();
}
