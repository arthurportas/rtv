package com.realtv.repo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Theme;

@Repository
@Transactional
public class ThemeDaoImpl extends GenericDaoImpl<Theme> implements ThemeDao {

	public Theme findByTheme(String theme) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Theme> criteria = builder.createQuery(Theme.class);
		Root<Theme> a = criteria.from(Theme.class);
		criteria.select(a).where(builder.equal(a.get("theme"), theme));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<Theme> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Theme> criteria = cb.createQuery(Theme.class);
		Root<Theme> theme = criteria.from(Theme.class);
		criteria.select(theme).orderBy(cb.asc(theme.get("theme")));
		return em.createQuery(criteria).getResultList();
	}

}
