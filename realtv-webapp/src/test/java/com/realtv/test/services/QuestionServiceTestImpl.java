/**
 * 
 */
package com.realtv.test.services;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;
import com.realtv.services.QuestionService;

/**
 * @author Arthur Portas
 * @date 26/12/2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class QuestionServiceTestImpl implements QuestionServiceTest {

	private final static Logger logger = LoggerFactory
			.getLogger(QuestionServiceTestImpl.class);

	@Autowired
	private QuestionService questionService;

	private Answer mockedAnswer;
	private Question mockedQuestion;
	private ArrayList<Answer> answers;

	@Before
	public void setup() {

		mockedAnswer = new Answer();
		mockedAnswer.setAnswer("answer");
		mockedAnswer.setCorrectAnswer("correctAnswer");

		mockedQuestion = new Question();
		mockedQuestion.setQuestion("question");

		answers = new ArrayList<Answer>();

		mockedAnswer.setQuestion(mockedQuestion);

		answers.add(mockedAnswer);

		mockedQuestion.setAnswers(answers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#create()
	 */
	@Test
	@Override
	public void create() {
		Assert.assertNotNull("question should not be null",
				questionService.create(mockedQuestion));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#delete()
	 */
	@Test
	@Override
	public void delete() {
		final Question question = questionService.create(mockedQuestion);
		Assert.assertNotNull("question should not be null", question);
		Assert.assertNotNull("question should not be null", question.getId());

		// It should be found
		Assert.assertNotNull("question should not be null",
				questionService.find(question.getId()));

		questionService.delete(question.getId());
		// It should not be found
		Assert.assertNull("question should be null",
				questionService.find(question.getId()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#update()
	 */
	@Test
	@Override
	public void update() {
		logger.debug("==update()==");
		Question question = questionService.create(mockedQuestion);
		Assert.assertNotNull("question should not be null", question);
		Assert.assertNotNull("question should not be null", question.getId());

		final Question lookup = questionService.find(question.getId());
		Assert.assertEquals(question.getId(), lookup.getId());

		question.setQuestion("the question");
		final Question questionUpdated = questionService.find(question.getId());
		Assert.assertEquals(question.getId(), questionUpdated.getId());

		Assert.assertNotNull("questionUpdated should not be null",
				questionUpdated.getAnswers());
		final Answer answer = questionUpdated.getAnswers().get(0);
		Assert.assertTrue(answer.getAnswer().equals("answer"));

		Assert.assertTrue(questionUpdated.getAnswers().get(0).getAnswer()
				.equals("answer"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#find()
	 */
	@Test
	@Override
	public void find() {

		logger.debug("==find()==");
		Question question = questionService.create(mockedQuestion);
		Assert.assertNotNull("question should not be null", question);
		Assert.assertNotNull("question should not be null", question.getId());

		final Question lookup = questionService.find(question.getId());
		Assert.assertEquals(question.getId(), lookup.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#getAll()
	 */
	@Test
	@Override
	public void getAll() {
		Assert.assertTrue(questionService.getAll().size() > 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#count()
	 */
	@Test
	@Override
	public void count() {
		Assert.assertTrue(questionService.getAll().size() >= 15);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#findAllOrderedByName()
	 */
	@Test
	@Override
	public void findAllOrderedByName() {
		List<Question> questions = questionService.findAllOrderedByName();
		Assert.assertNotNull("questions should not be null", questions);
		/* uses Criteria Builder */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.QuestionServiceTest#findAnswersByQuestionNamedQuery
	 * ()
	 */
	@Test
	@Override
	public void findAnswersByQuestionNamedQuery() {
		/* get first question */
		Question question = questionService.getAll().get(0);
		List<Answer> answers = questionService
				.findAnswersByQuestionNamedQuery(question.getQuestion());
		Assert.assertNotNull("answers should not be null", answers);
		Assert.assertEquals(answers.size(), 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.QuestionServiceTest#findQuestionNamedQuery()
	 */
	@Test
	@Override
	public void findQuestionNamedQuery() {
		Question question = questionService.getAll().get(0);
		final Question lookup = questionService.findQuestionNamedQuery(question
				.getQuestion());
		Assert.assertNotNull("lookup should not be null", lookup);
		Assert.assertEquals(lookup.getId(), question.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#registerAnswers()
	 */
	@Test
	@Override
	public void registerAnswers() {
		logger.debug("==registerAnswers()==");

		Question question1 = questionService.getAll().get(0);
		Assert.assertNotNull("question1 should not be null", question1);
		Question question2 = questionService.getAll().get(8);
		Assert.assertNotNull("question2 should not be null", question2);
	}
}
