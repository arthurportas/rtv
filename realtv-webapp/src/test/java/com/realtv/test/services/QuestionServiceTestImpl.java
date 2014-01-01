/**
 * 
 */
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
import com.realtv.domain.QuestionLevel;
import com.realtv.services.interfaces.IQuestionService;
import com.realtv.test.services.interfaces.IQuestionServiceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * @author Arthur Portas
 * @date 26/12/2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class QuestionServiceTestImpl implements IQuestionServiceTest {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(QuestionServiceTestImpl.class);

	@Autowired
	private IQuestionService questionService;

	private Answer mockedAnswer;
	private Question mockedQuestion;
	private QuestionLevel mockedQuestionLevel;
	private ArrayList<Answer> answers;
	private ArrayList<Question> questions;

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

		mockedQuestionLevel = new QuestionLevel();
		mockedQuestionLevel.setDificultyLevel(1);
		mockedQuestionLevel.setTimeAvailableToAnswer(30);

		questions = new ArrayList<Question>();
		questions.add(mockedQuestion);

		mockedQuestionLevel.setQuestions(questions);
		mockedQuestion.setQuestionLevel(mockedQuestionLevel);
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("question should not be null",
				questionService.create(mockedQuestion));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Question question = questionService.create(mockedQuestion);
		assertNotNull("question should not be null", question);
		assertNotNull("question should not be null", question.getId());

		// It should be found
		assertNotNull("question should not be null",
				questionService.find(question.getId()));

		questionService.delete(question.getId());
		// It should not be found
		assertNull("question should be null",
				questionService.find(question.getId()));
	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		Question question = questionService.create(mockedQuestion);
		assertNotNull("question should not be null", question);
		assertNotNull("question should not be null", question.getId());

		final Question lookup = questionService.find(question.getId());
		assertEquals(question.getId(), lookup.getId());

		question.setQuestion("the question");
		final Question questionUpdated = questionService.find(question.getId());
		assertEquals(question.getId(), questionUpdated.getId());

		assertNotNull("questionUpdated should not be null",
				questionUpdated.getAnswers());
		final Answer answer = questionUpdated.getAnswers().get(0);
		
		assertTrue(answer.getAnswer().equals("answer"));

		assertTrue(questionUpdated.getAnswers().get(0).getAnswer()
				.equals("answer"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Question question = questionService.create(mockedQuestion);
		assertNotNull("question should not be null", question);
		assertNotNull("question should not be null", question.getId());

		final Question lookup = questionService.find(question.getId());
		assertEquals(question.getId(), lookup.getId());
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(questionService.getAll().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(questionService.getAll().size() >= 15);
	}

	@Test
	@Override
	public void findAllOrderedByName() {
		slf4jLogger.info("==count()==");
		List<Question> questions = questionService.findAllOrderedByName();
		assertNotNull("questions should not be null", questions);
		/* uses Criteria Builder */
	}

	@Test
	@Override
	public void findAnswersByQuestionNamedQuery() {
		slf4jLogger.info("==findAnswersByQuestionNamedQuery()==");
		/* get first question */
		final Question question = questionService.getAll().get(0);
		List<Answer> answers = questionService
				.findAnswersByQuestionNamedQuery(question.getQuestion());
		assertNotNull("answers should not be null", answers);
		assertEquals(answers.size(), 4);
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
		slf4jLogger.info("==findQuestionNamedQuery()==");
		final Question question = questionService.getAll().get(0);
		final Question lookup = questionService.findQuestionNamedQuery(question
				.getQuestion());
		assertNotNull("lookup should not be null", lookup);
		assertEquals(lookup.getId(), question.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#registerAnswers()
	 */
	@Test
	@Override
	public void registerAnswers() {
		slf4jLogger.info("==registerAnswers()==");
		final Question question1 = questionService.getAll().get(0);
		assertNotNull("question1 should not be null", question1);
		final Question question2 = questionService.getAll().get(8);
		assertNotNull("question2 should not be null", question2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#registerQuestionLevel()
	 */
	@Test
	@Override
	public void registerQuestionLevel() {
		slf4jLogger.info("==registerQuestionLevel()==");
		assertNotNull("question1 should not be null",
				mockedQuestion.getQuestionLevel());
		assertEquals(30, mockedQuestion.getQuestionLevel()
				.getTimeAvailableToAnswer());

		final Question question1 = questionService.getAll().get(0);
		assertNotNull("question1 should not be null", question1);
		assertEquals(30, question1.getQuestionLevel()
				.getTimeAvailableToAnswer());

		final Question question2 = questionService.find(3L);
		assertNotNull("question2 should not be null", question2);
		assertEquals(30, question2.getQuestionLevel()
				.getTimeAvailableToAnswer());

		final Question question3 = questionService.find(15L);
		assertNotNull("question3 should not be null", question3);
		assertEquals(5, question3.getQuestionLevel()
				.getTimeAvailableToAnswer());
	}
}
