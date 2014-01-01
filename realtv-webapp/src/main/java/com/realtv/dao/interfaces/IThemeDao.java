package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.Theme;

public interface IThemeDao extends IGenericDao<Theme>{
	
	/**
	 * 
	 * */
	public Theme findByTheme(String theme);

	/**
	 * 
	 * */
	public List<Theme> findAllOrderedByName();

}
