package com.realtv.test.services;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Answer;
import com.realtv.services.AnswerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AnswerServiceTestImpl implements AnswerServiceTest {

	@Autowired
	private AnswerService answerService;

	private Answer mockedAnswer;

	@Before
	public void setup() {
		mockedAnswer = new Answer();
		mockedAnswer.setAnswer("answer");
		mockedAnswer.setCorrectAnswer("correctAnswer");
	}

	@Test
	@Override
	public void findAllAnswersNamedQuery() {
		List<Answer> answers = answerService.findAllNamedQuery();
		Assert.assertNotNull("answers should not be null", answers);
		Assert.assertEquals(60, answers.size());
	}

	@Test
	@Override
	public void create() {
		Assert.assertNotNull("answer should not be null",
				answerService.create(mockedAnswer));
	}

	@Test
	@Override
	public void delete() {

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
		Assert.assertTrue(answerService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		Assert.assertTrue(answerService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Ignore
	@Override
	public void count() {
		Assert.assertTrue(answerService.getAll().size() >= 60);
	}
}
