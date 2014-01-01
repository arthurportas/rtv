package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.ShowType;

public interface IShowTypeDao extends IGenericDao<ShowType> {
	public List<ShowType> findAllNamedQuery();
}
