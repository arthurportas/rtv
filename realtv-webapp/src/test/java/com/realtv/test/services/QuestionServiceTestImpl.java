/**
 * 
 */
package com.realtv.test.services;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Autowired
	private QuestionService questionService;

	private Answer mockedAnswer;
	private Question mockedQuestion;

	@Before
	public void setup() {
		mockedAnswer = new Answer();
		mockedAnswer.setAnswer("answer");
		mockedAnswer.setCorrectAnswer("correctAnswer");

		mockedQuestion = new Question();
		mockedQuestion.setQuestion("question");

		mockedAnswer.setQuestion(mockedQuestion);

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

		ArrayList<Answer> answers = new ArrayList<Answer>();
		answers.add(mockedAnswer);

		mockedQuestion.setAnswers(answers);

		Question question = questionService.create(mockedQuestion);
		Assert.assertNotNull("question should not be null", question);
		Assert.assertNotNull("question should not be null", question.getId());
		Assert.assertNotNull("question should not be null",
				question.getAnswers());
		Assert.assertEquals(1, question.getAnswers().size());

		question.setQuestion("the question");

		questionService.update(question);

		final Question questionUpdated = questionService.find(question.getId());
		Assert.assertNotNull("question should not be null", questionUpdated);
		Assert.assertNotNull("question should not be null",
				questionUpdated.getId());
		Assert.assertNotNull("question should not be null",
				questionUpdated.getAnswers());
		Assert.assertEquals(1, questionUpdated.getAnswers().size());
		Assert.assertEquals(question.getId(), questionUpdated.getId());

		Assert.assertTrue(questionUpdated.getQuestion().equals("the question"));
		final Answer answer = questionUpdated.getAnswers().get(0);
		Assert.assertTrue(answer.getAnswer().equals("answer"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#find()
	 */
	@Override
	public void find() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#getAll()
	 */
	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#count()
	 */
	@Override
	public void count() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#findAllOrderedByName()
	 */
	@Override
	public void findAllOrderedByName() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.QuestionServiceTest#findAnswersByQuestionNamedQuery
	 * ()
	 */
	@Override
	public void findAnswersByQuestionNamedQuery() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.realtv.test.services.QuestionServiceTest#findQuestionNamedQuery()
	 */
	@Override
	public void findQuestionNamedQuery() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.QuestionServiceTest#registerAnswers()
	 */
	@Override
	public void registerAnswers() {
		// TODO Auto-generated method stub

	}

}
