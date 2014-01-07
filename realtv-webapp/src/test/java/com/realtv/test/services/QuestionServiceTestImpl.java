/**
 * 
 */
package com.realtv.test.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;
import com.realtv.domain.QuestionLevel;
import com.realtv.domain.Theme;
import com.realtv.services.interfaces.IQuestionService;
import com.realtv.test.services.interfaces.IQuestionServiceTest;

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

	/*Properties Injected*/
	@Value("${Question.ALL.QuestionLevel.Time.To.Answer}")
	private String QUESTION_ALL_QUESTIONLEVEL_TIME_TO_ANSWER;
	
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

	@After
	public void tearDown() {
		questionService = null;
		mockedQuestion = null;
		mockedQuestionLevel = null;
		answers = null;
		questions = null;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#create()
	 */
	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("question should not be null",
				questionService.create(mockedQuestion));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#delete()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#update()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#find()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#getAll()
	 */
	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(questionService.getAll().size() > 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#count()
	 */
	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(questionService.getAll().size() >= 15);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#findAllOrderedByName()
	 */
	@Test
	@Override
	public void findAllOrderedByName() {
		slf4jLogger.info("==count()==");
		List<Question> questions = questionService.findAllOrderedByName();
		assertNotNull("questions should not be null", questions);
		/* uses Criteria Builder */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.IQuestionServiceTest#findAnswersByQuestionNamedQuery()
	 */
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
	 * com.realtv.test.services.IQuestionServiceTest#findQuestionNamedQuery()
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
	 * @see com.realtv.test.services.IQuestionServiceTest#registerAnswers()
	 */
	@Test
	@Override
	public void registerAnswers() {
		slf4jLogger.info("==registerAnswers()==");
		final Question question1 = questionService.getAll().get(0);
		assertNotNull("question1 should not be null", question1);
		assertNotNull("question1(answers) should not be null", question1.getAnswers());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.IQuestionServiceTest#registerQuestionLevel()
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.IQuestionServiceTest#getTimeToAnswer()
	 */
	@Test
	@Override
	public void getTimeToAnswer() {
		slf4jLogger.info("==getTimeToAnswer()==");
		slf4jLogger.info("==Entities needed: Question q, Theme t, QuestionLevel ql==");
		final Question question = questionService.getAll().get(0);
		final Theme theme =  question.getTheme();
		final QuestionLevel questionLevel =  question.getQuestionLevel();
		
		assertNotNull("question should not be null", question);
		assertNotNull("theme should not be null", theme);
		assertNotNull("questionLevel should not be null", questionLevel);
		
		slf4jLogger.info("==Question:" + question.getQuestion());
		slf4jLogger.info("==Theme:" + theme.getTheme());
		slf4jLogger.info("==TimeToAnswer:" + questionLevel.getTimeAvailableToAnswer());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.IQuestionServiceTest#getDificultyLevel()
	 */
	@Test
	@Override
	public void getDificultyLevel() {
		slf4jLogger.info("==getDificultyLevel()==");
		slf4jLogger.info("==Entities needed: Question q, Theme t, QuestionLevel ql==");
		final Question question = questionService.getAll().get(0);
		final Theme theme =  question.getTheme();
		final QuestionLevel questionLevel =  question.getQuestionLevel();
		
		assertNotNull("question should not be null", question);
		assertNotNull("theme should not be null", theme);
		assertNotNull("questionLevel should not be null", questionLevel);
		
		slf4jLogger.info("==Question:" + question.getQuestion());
		slf4jLogger.info("==Theme:" + theme.getTheme());
		slf4jLogger.info("==TimeToAnswer:" + questionLevel.getTimeAvailableToAnswer());
		slf4jLogger.info("==DificultyLevel:" + questionLevel.getDificultyLevel());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.IQuestionServiceTest#getAnswers()
	 */
	@Test
	@Override
	public void getAnswers() {
		slf4jLogger.info("==getAnswers()==");
		final Question question1 = questionService.getAll().get(0);
		assertNotNull("question1 should not be null", question1);
		assertNotNull("question1(answers) should not be null", question1.getAnswers());
		
		for (Answer answer : question1.getAnswers()) {
			slf4jLogger.info("==Answer()==");
			slf4jLogger.info("==answer.getAnswer() ==" + answer.getAnswer());
			slf4jLogger.info("==answer.getCorrectAnswer() ==" + answer.getCorrectAnswer());
		}
		final Question question2 = questionService.getAll().get(8);
		assertNotNull("question2 should not be null", question2);
	}
}
