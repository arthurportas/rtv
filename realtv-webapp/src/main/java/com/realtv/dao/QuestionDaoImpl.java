package com.realtv.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.realtv.dao.interfaces.IQuestionDao;
import com.realtv.domain.Answer;
import com.realtv.domain.Question;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class QuestionDaoImpl extends GenericDaoImpl<Question> implements IQuestionDao {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(QuestionDaoImpl.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#findAllOrderedByName()
	 */
	public List<Question> findAllOrderedByName() {
		slf4jLogger.info("==List<Question> findAllOrderedByName()==");
		CriteriaBuilder cb = super.em.getCriteriaBuilder();
		CriteriaQuery<Question> criteria = cb.createQuery(Question.class);
		Root<Question> question = criteria.from(Question.class);
		criteria.select(question).orderBy(cb.asc(question.get("question")));
		return super.em.createQuery(criteria).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#registerAnswers(java.util.List)
	 */
	@Override
	public void registerAnswers(Question question, List<Answer> answers) {
		slf4jLogger.info("==registerAnswers(Question question, List<Answer> answers)==");
		if(answers!=null && !answers.isEmpty()){
			question.setAnswers(answers);
			super.em.persist(question);
		}	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.repo.QuestionDao#findByQuestionNamedQuery(java.lang.String)
	 */
	@Override
	public Question findQuestionNamedQuery(String question) {
		slf4jLogger.info("==Question findQuestionNamedQuery(String question)==");
		Query q = super.em.createNamedQuery(Question.FIND_BY_QUESTION).setParameter(
				"question", question);
		return (Question) q.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.repo.QuestionDao#findAnswersByQuestionNamedQuery(java.lang
	 * .String)
	 */
	@Override
	public List<Answer> findAnswersByQuestionNamedQuery(String question) {
		slf4jLogger.info("==List<Answer> findAnswersByQuestionNamedQuery(String question)==");
		Query query = em.createNamedQuery(Question.FIND_ANSWERS_BY_QUESTION)
				.setParameter("question", question);
		Question q = (Question) query.getSingleResult();
		return q.getAnswers();
	}
}
