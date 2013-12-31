package com.realtv.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.realtv.domain.QuestionLevel;

@Repository
public class QuestionLevelDaoImpl extends GenericDaoImpl<QuestionLevel>
		implements QuestionLevelDao {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(QuestionLevelDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionLevel> findAllNamedQuery() {
		slf4jLogger.info("==List<QuestionLevel> findAllNamedQuery()==");
		return super.em.createNamedQuery(QuestionLevel.FIND_ALL)
				.getResultList();
	}

	/*@Override
	public int getAvailableTimeToAnswer(Question question) {
		List<QuestionLevel> list = findAllNamedQuery();
		for (QuestionLevel questionLevel : list) {
			if(questionLevel.getId().equals(question.getId())){
				return questionLevel.getTimeAvailableToAnswer();
			}
		}
		return 0;
	}*/
}
