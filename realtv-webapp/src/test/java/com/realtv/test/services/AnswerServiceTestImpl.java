package com.realtv.test.services;

import java.util.ArrayList;
import java.util.List;

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
import com.realtv.services.interfaces.IAnswerService;
import com.realtv.test.services.interfaces.IAnswerServiceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AnswerServiceTestImpl implements IAnswerServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(AnswerServiceTestImpl.class);
	
	@Autowired
	private IAnswerService answerService;

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
		assertNotNull("answers should not be null", answers);
		assertEquals(60, answers.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("answer should not be null",
				answerService.create(mockedAnswer));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Answer answer = answerService.create(mockedAnswer);
		assertNotNull("answer should not be null", answer);
		assertNotNull("answer should not be null", answer.getId());
		// It should be found
		assertNotNull("answer should not be null",
				answerService.find(answer.getId()));

		answerService.delete(answer.getId());
		// It should not be found
		assertNull("answer should be null",
				answerService.find(answer.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		final Answer answer = answerService.create(mockedAnswer);
		assertNotNull("answer should not be null", answer);
		assertNotNull("answer should not be null", answer.getId());
		answer.setAnswer("answer updated");

		answerService.update(answer);
		final Answer answerUpdated = answerService.find(answer.getId());
		assertNotNull("answer should not be null", answerUpdated);
		assertNotNull("answer should not be null", answerUpdated.getId());
		assertEquals(answer.getId(), answerUpdated.getId());
		assertTrue(answerUpdated.getAnswer().equals("answer updated"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Answer answer = answerService.create(mockedAnswer);
		assertNotNull("answer should not be null", answer);
		assertNotNull("answer should not be null", answer.getId());
		// It should be found
		assertNotNull("answer should not be null",
				answerService.find(answer.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(answerService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		assertTrue(answerService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(answerService.getAll().size() >= 60);
	}

	@Test
	@Override
	/*should fail...see how to enforce constraint*/
	public void createAnswerWithoutQuestionAssociation() {
		 Answer answer = new Answer();
		 answer.setAnswer("the answer");
		 answer.setCorrectAnswer("correctAnswer");

		 answerService.create(mockedAnswer);
		
	}

}
