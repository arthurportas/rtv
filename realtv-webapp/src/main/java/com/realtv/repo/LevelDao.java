package com.realtv.repo;

import java.util.List;

import com.realtv.domain.Level;

public interface LevelDao extends GenericDao<Level> {
	public List<Level> findAllNamedQuery();
}
