package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Show;

public interface ShowDao extends GenericDao<Show> {
	public List<Show> findAllNamedQuery();
}
