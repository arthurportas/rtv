package com.realtv.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;

@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#findById(Long)
	 */
	public Question findById(Long id) {
		return em.find(Question.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#findByQuestion(String)
	 */
	public Question findByQuestion(String question) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Question> criteria = builder.createQuery(Question.class);
		Root<Question> q = criteria.from(Question.class);
		criteria.select(q).where(builder.equal(q.get("question"), question));
		return em.createQuery(criteria).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#findAllOrderedByName()
	 */
	public List<Question> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Question> criteria = cb.createQuery(Question.class);
		Root<Question> question = criteria.from(Question.class);
		criteria.select(question).orderBy(cb.asc(question.get("question")));
		return em.createQuery(criteria).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#register(Question)
	 */
	public void register(Question question) {
		em.persist(question);
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#registerAnswers(java.util.List)
	 */
	@Override
	public void registerAnswers(List<Answer> answers) {

		List<Answer> list = new ArrayList<Answer>();

		for (Answer answer : answers) {
			list.add(answer);
			em.persist(answer);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#findAllAnswersByQuestion()
	 */
	@Override
	public List<Question> findAllQuestions() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Question> cq = cb.createQuery(Question.class);
		Root<Question> rootEntry = cq.from(Question.class);
		CriteriaQuery<Question> all = cq.select(rootEntry);
		TypedQuery<Question> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.repo.QuestionDao#findAllAnswersByQuestion()
	 */
	@Override
	public List<Answer> findAllAnswersByQuestion(String question) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.repo.QuestionDao#findByQuestionNamedQuery(java.lang.String)
	 */
	@Override
	public Question findByQuestionNamedQuery(String question) {
		Query q = em.createNamedQuery(Question.FIND_BY_QUESTION).setParameter(
				"question", "Quem foi o 1 Rei de Portugal?");
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
				.setParameter("question", "Quem foi o 1 Rei de Portugal?");
		Question q = (Question) query.getSingleResult();
		return q.getAnswers();
	}
}
