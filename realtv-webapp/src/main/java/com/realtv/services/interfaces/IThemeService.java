/**
 * 
 */
package com.realtv.services.interfaces;

import java.util.List;

import com.realtv.domain.Theme;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IThemeService {
	
	public Theme create(Theme theme);

	public void delete(Long id);

	public Theme update(Theme theme);

	public Theme find(Long id);

	public List<Theme> getAll();

	public Long count();

	public List<Theme> findAllOrderedByName();
	
	public Theme findByTheme(String theme);
}
