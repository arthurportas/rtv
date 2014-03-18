package com.realtv.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IShowDao;
import com.realtv.domain.Show;
import com.realtv.domain.ShowType;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ShowDaoImpl extends GenericDaoImpl<Show> implements IShowDao {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ShowDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Show> findAllNamedQuery() {
		slf4jLogger.info("==List<Show> findAllNamedQuery()==");
		return super.em.createNamedQuery(Show.FIND_ALL).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.realtv.dao.interfaces.IShowDao#findByShowTypeNamedQuery(com.realtv.domain.ShowType)
	 */
	@Override
	public List<Show> findByShowTypeNamedQuery(ShowType showType) {
		slf4jLogger.info("==List<Show> findByShowTypeNamedQuery(ShowType showType)==");
		return super.em.createNamedQuery(Show.FIND_BY_SHOW_TYPE).setParameter(1, showType).getResultList();
	}	
}
