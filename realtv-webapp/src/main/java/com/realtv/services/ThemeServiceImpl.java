/**
 * 
 */
package com.realtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtv.domain.Theme;
import com.realtv.repo.ThemeDao;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class ThemeServiceImpl implements ThemeService {

	@Autowired
	private ThemeDao themeDao;

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#create(com.realtv.domain.Theme)
	 */
	@Override
	public Theme create(Theme theme) {
		return themeDao.create(theme);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		themeDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#update(com.realtv.domain.Theme)
	 */
	@Override
	public Theme update(Theme theme) {
		return themeDao.update(theme);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#find(java.lang.Long)
	 */
	@Override
	public Theme find(Long id) {
		return themeDao.find(id);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#getAll()
	 */
	@Override
	public List<Theme> getAll() {
		return themeDao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#count()
	 */
	@Override
	public Long count() {
		return themeDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#findAllOrderedByName()
	 */
	@Override
	public List<Theme> findAllOrderedByName() {
		return themeDao.findAllOrderedByName();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#findByTheme()
	 */
	@Override
	public Theme findByTheme(String theme) {
		return themeDao.findByTheme(theme);
	}

}
