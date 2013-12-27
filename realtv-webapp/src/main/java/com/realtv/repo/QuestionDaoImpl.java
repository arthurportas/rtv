package com.realtv.repo;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

@Repository
@Transactional
public class QuestionDaoImpl extends GenericDaoImpl<Question> implements QuestionDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#findAllOrderedByName()
	 */
	public List<Question> findAllOrderedByName() {
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

		Query query = em.createNamedQuery(Question.FIND_ANSWERS_BY_QUESTION)
				.setParameter("question", question);
		Question q = (Question) query.getSingleResult();
		return q.getAnswers();
	}
}
