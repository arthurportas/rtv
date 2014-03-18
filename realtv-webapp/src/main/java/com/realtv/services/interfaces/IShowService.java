/**
 * 
 */
package com.realtv.services.interfaces;

import java.util.List;

import com.realtv.domain.Show;
import com.realtv.domain.ShowType;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IShowService {
	
	public Show create(Show show);

	public void delete(Long id);

	public Show update(Show show);

	public Show find(Long id);

	public List<Show> getAll();

	public Long count();

	public List<Show> findAllNamedQuery();
	
	public List<Show> findByShowTypeNamedQuery(ShowType showType);
}
