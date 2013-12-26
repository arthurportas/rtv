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
public class AnswerServiceTestImpl implements AnswerServiceTest{
	
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
	public void findAllAnswersNamedQuery(){
		List<Answer> answers = answerService.findAllNamedQuery();
		Assert.assertNotNull("answers should not be null", answers);
		Assert.assertEquals(60, answers.size());
	}

	@Test
	@Override
	public void create() {
		Assert.assertNotNull("answer should not be null", answerService.create(mockedAnswer));
	}

	@Test
	@Ignore
	@Override
	public void delete(Integer id) {
		
		
	}

	@Test
	@Ignore
	@Override
	public Answer update(Answer answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	@Ignore
	@Override
	public Answer find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	@Ignore
	@Override
	public List<Answer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	@Ignore
	@Override
	public List<Answer> findAllNamedQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	@Ignore
	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
