package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.Show;
import com.realtv.domain.ShowType;

public interface IShowDao extends IGenericDao<Show> {
	public List<Show> findAllNamedQuery();
	public List<Show> findByShowTypeNamedQuery(ShowType showType);
}
