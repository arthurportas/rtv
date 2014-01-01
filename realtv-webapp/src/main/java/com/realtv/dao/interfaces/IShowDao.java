package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.Show;

public interface IShowDao extends IGenericDao<Show> {
	public List<Show> findAllNamedQuery();
}
