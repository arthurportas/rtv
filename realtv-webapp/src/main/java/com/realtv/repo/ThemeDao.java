package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Theme;

public interface ThemeDao extends GenericDao<Theme>{
	
	/**
	 * 
	 * */
	public Theme findByTheme(String theme);

	/**
	 * 
	 * */
	public List<Theme> findAllOrderedByName();

}
