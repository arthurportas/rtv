/**
 * 
 */
package com.realtv.services;

import java.util.List;

import com.realtv.domain.Level;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface LevelService {
	
	public Level create(Level level);

	public void delete(Long id);

	public Level update(Level level);

	public Level find(Long id);

	public List<Level> getAll();

	public Long count();

	public List<Level> findAllNamedQuery();
}
