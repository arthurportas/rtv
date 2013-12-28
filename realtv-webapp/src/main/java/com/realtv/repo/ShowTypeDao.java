package com.realtv.repo;

import java.util.List;

import com.realtv.domain.ShowType;

public interface ShowTypeDao extends GenericDao<ShowType> {
	public List<ShowType> findAllNamedQuery();
}
