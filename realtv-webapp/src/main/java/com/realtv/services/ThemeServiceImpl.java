/**
 * 
 */
package com.realtv.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtv.dao.interfaces.IThemeDao;
import com.realtv.domain.Theme;
import com.realtv.services.interfaces.IThemeService;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
@Service
public class ThemeServiceImpl implements IThemeService {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ThemeServiceImpl.class);
	
	@Autowired
	private IThemeDao themeDao;

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#create(com.realtv.domain.Theme)
	 */
	@Override
	public Theme create(Theme theme) {
		slf4jLogger.info("==Theme create(Theme theme)==");
		return themeDao.create(theme);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		slf4jLogger.info("==void delete(Long id)==");
		themeDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#update(com.realtv.domain.Theme)
	 */
	@Override
	public Theme update(Theme theme) {
		slf4jLogger.info("==Theme update(Theme theme)==");
		return themeDao.update(theme);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#find(java.lang.Long)
	 */
	@Override
	public Theme find(Long id) {
		slf4jLogger.info("==Theme find(Long id)==");
		return themeDao.find(id);
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#getAll()
	 */
	@Override
	public List<Theme> getAll() {
		slf4jLogger.info("==List<Theme> getAll()==");
		return themeDao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#count()
	 */
	@Override
	public Long count() {
		slf4jLogger.info("==Long count()==");
		return themeDao.count();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#findAllOrderedByName()
	 */
	@Override
	public List<Theme> findAllOrderedByName() {
		slf4jLogger.info("==List<Theme> findAllOrderedByName()==");
		return themeDao.findAllOrderedByName();
	}

	/* (non-Javadoc)
	 * @see com.realtv.services.ThemeService#findByTheme()
	 */
	@Override
	public Theme findByTheme(String theme) {
		slf4jLogger.info("==Theme findByTheme(String theme)==");
		return themeDao.findByTheme(theme);
	}

}
