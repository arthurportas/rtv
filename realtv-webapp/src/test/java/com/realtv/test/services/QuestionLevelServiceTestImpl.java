package com.realtv.test.services;

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

import com.realtv.domain.QuestionLevel;
import com.realtv.services.QuestionLevelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class QuestionLevelServiceTestImpl implements QuestionLevelServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(QuestionLevelServiceTestImpl.class);

	@Autowired
	private QuestionLevelService questionLevelService;

	private QuestionLevel mockedQuestionLevel;

	@Before
	public void setup() {
		mockedQuestionLevel = new QuestionLevel();
		mockedQuestionLevel.setDificultyLevel(1);
		mockedQuestionLevel.setTimeAvailableToAnswer(15);
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("questionLevel should not be null",
				questionLevelService.create(mockedQuestionLevel));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final QuestionLevel questionLevel = questionLevelService
				.create(mockedQuestionLevel);
		Assert.assertNotNull("questionLevel should not be null", questionLevel);
		Assert.assertNotNull("questionLevel should not be null",
				questionLevel.getId());
		// It should be found
		Assert.assertNotNull("questionLevel should not be null",
				questionLevelService.find(questionLevel.getId()));

		questionLevelService.delete(questionLevel.getId());
		// It should not be found
		Assert.assertNull("questionLevel should be null",
				questionLevelService.find(questionLevel.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		QuestionLevel questionLevel = questionLevelService
				.create(mockedQuestionLevel);
		Assert.assertNotNull("questionLevel should not be null", questionLevel);
		Assert.assertNotNull("questionLevel should not be null",
				questionLevel.getId());
		questionLevel.setDificultyLevel(2);

		questionLevelService.update(questionLevel);

		final QuestionLevel questionLevelUpdated = questionLevelService
				.find(questionLevel.getId());
		Assert.assertNotNull("questionLevelUpdated should not be null",
				questionLevelUpdated);
		Assert.assertNotNull("questionLevelUpdated should not be null",
				questionLevelUpdated.getId());
		Assert.assertEquals(questionLevel.getId(), questionLevelUpdated.getId());
		Assert.assertEquals(questionLevelUpdated.getDificultyLevel(), 2);
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final QuestionLevel questionLevel = questionLevelService
				.create(mockedQuestionLevel);
		Assert.assertNotNull("questionLevel should not be null", questionLevel);
		Assert.assertNotNull("questionLevel should not be null",
				questionLevel.getId());
		// It should be found
		Assert.assertNotNull("questionLevel should not be null",
				questionLevelService.find(questionLevel.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(questionLevelService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		Assert.assertTrue(questionLevelService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(questionLevelService.getAll().size() >= 5);
	}

}
