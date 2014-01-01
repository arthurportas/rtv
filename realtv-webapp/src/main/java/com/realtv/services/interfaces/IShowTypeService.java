/**
 * 
 */
package com.realtv.services.interfaces;

import java.util.List;

import com.realtv.domain.ShowType;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IShowTypeService {
	
	public ShowType create(ShowType showType);

	public void delete(Long id);

	public ShowType update(ShowType showType);

	public ShowType find(Long id);

	public List<ShowType> getAll();

	public Long count();

	public List<ShowType> findAllNamedQuery();
}
