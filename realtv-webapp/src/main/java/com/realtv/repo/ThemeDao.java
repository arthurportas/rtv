package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Question;
import com.realtv.domain.Theme;

public interface ThemeDao {
	
	/**
	 * 
	 * */
	public Theme findById(Long id);

	/**
	 * 
	 * */
	public Theme findByTheme(String theme);

	/**
	 * 
	 * */
	public List<Theme> findAllOrderedByName();

	/**
	 * 
	 * */
	public void register(Theme theme);

	/**
	 * 
	 * */
	public Question setQuestionAssociation(Question question);
}
