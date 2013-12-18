package com.realtv.repo;

import java.util.List;

import javax.persistence.EntityManager;
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
public class AnswerDaoImpl implements AnswerDao {
	@Autowired
	private EntityManager em;

	public Answer findById(Long id) {
		return em.find(Answer.class, id);
	}

	public Answer findByAnswer(String answer) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Answer> criteria = builder.createQuery(Answer.class);
		Root<Answer> a = criteria.from(Answer.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(a).where(builder.equal(a.get("answer"), answer));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<Answer> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Answer> criteria = cb.createQuery(Answer.class);
		Root<Answer> answer = criteria.from(Answer.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(answer).orderBy(cb.asc(answer.get("answer")));
		return em.createQuery(criteria).getResultList();
	}

	public void register(Answer answer) {
		em.persist(answer);
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.repo.AnswerDao#setQuestionAssociation(com.realtv.domain.Question
	 * )
	 */
	@Override
	public Question setQuestionAssociation(Question question) {
		em.persist(question);
		return question;
	}
}
