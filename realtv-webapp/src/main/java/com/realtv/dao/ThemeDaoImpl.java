package com.realtv.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.dao.interfaces.IThemeDao;
import com.realtv.domain.Theme;

@Repository
@Transactional
public class ThemeDaoImpl extends GenericDaoImpl<Theme> implements IThemeDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ThemeDaoImpl.class);
	
	public Theme findByTheme(String theme) {
		slf4jLogger.info("==Theme findByTheme(String theme)==");
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Theme> criteria = builder.createQuery(Theme.class);
		Root<Theme> a = criteria.from(Theme.class);
		criteria.select(a).where(builder.equal(a.get("theme"), theme));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<Theme> findAllOrderedByName() {
		slf4jLogger.info("==List<Theme> findAllOrderedByName()==");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Theme> criteria = cb.createQuery(Theme.class);
		Root<Theme> theme = criteria.from(Theme.class);
		criteria.select(theme).orderBy(cb.asc(theme.get("theme")));
		return em.createQuery(criteria).getResultList();
	}

}
