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
import com.realtv.services.AnswerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AnswerServiceTestImpl implements AnswerServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(AnswerServiceTestImpl.class);
	
	@Autowired
	private AnswerService answerService;

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

	@Test
	@Override
	public void findAllAnswersNamedQuery() {
		slf4jLogger.info("==findAllAnswersNamedQuery()==");
		List<Answer> answers = answerService.findAllNamedQuery();
		Assert.assertNotNull("answers should not be null", answers);
		Assert.assertEquals(60, answers.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("answer should not be null",
				answerService.create(mockedAnswer));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Answer answer = answerService.create(mockedAnswer);
		Assert.assertNotNull("answer should not be null", answer);
		Assert.assertNotNull("answer should not be null", answer.getId());
		// It should be found
		Assert.assertNotNull("answer should not be null",
				answerService.find(answer.getId()));

		answerService.delete(answer.getId());
		// It should not be found
		Assert.assertNull("answer should be null",
				answerService.find(answer.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		Answer answer = answerService.create(mockedAnswer);
		Assert.assertNotNull("answer should not be null", answer);
		Assert.assertNotNull("answer should not be null", answer.getId());
		answer.setAnswer("answer updated");

		answerService.update(answer);
		final Answer answerUpdated = answerService.find(answer.getId());
		Assert.assertNotNull("answer should not be null", answerUpdated);
		Assert.assertNotNull("answer should not be null", answerUpdated.getId());
		Assert.assertEquals(answer.getId(), answerUpdated.getId());
		Assert.assertTrue(answerUpdated.getAnswer().equals("answer updated"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Answer answer = answerService.create(mockedAnswer);
		Assert.assertNotNull("answer should not be null", answer);
		Assert.assertNotNull("answer should not be null", answer.getId());
		// It should be found
		Assert.assertNotNull("answer should not be null",
				answerService.find(answer.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(answerService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		Assert.assertTrue(answerService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(answerService.getAll().size() >= 60);
	}

}
