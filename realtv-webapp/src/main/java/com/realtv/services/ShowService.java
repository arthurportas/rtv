/**
 * 
 */
package com.realtv.services;

import java.util.List;

import com.realtv.domain.Show;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface ShowService {
	
	public Show create(Show show);

	public void delete(Long id);

	public Show update(Show show);

	public Show find(Long id);

	public List<Show> getAll();

	public Long count();

	public List<Show> findAllNamedQuery();
}
