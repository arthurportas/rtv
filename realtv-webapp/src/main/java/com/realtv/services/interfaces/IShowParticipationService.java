/**
 * 
 */
package com.realtv.services.interfaces;

import java.util.List;

import com.realtv.domain.ShowParticipation;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IShowParticipationService {
	
	public ShowParticipation create(ShowParticipation showParticipation);

	public void delete(Long id);

	public ShowParticipation update(ShowParticipation ShowParticipation);

	public ShowParticipation find(Long id);

	public List<ShowParticipation> getAll();

	public Long count();

	public List<ShowParticipation> findAllNamedQuery();
}
