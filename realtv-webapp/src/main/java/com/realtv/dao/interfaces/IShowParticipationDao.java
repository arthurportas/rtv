package com.realtv.dao.interfaces;

import java.util.List;

import com.realtv.domain.ShowParticipation;

public interface IShowParticipationDao extends IGenericDao<ShowParticipation> {
	public List<ShowParticipation> findAllNamedQuery();
}
