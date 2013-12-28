package com.realtv.test.services;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Level;
import com.realtv.services.LevelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class LevelServiceTestImpl implements LevelServiceTest {

	@Autowired
	private LevelService levelService;

	private Level mockedLevel;
	
	@Before
	public void setup() {
		mockedLevel = new Level();
		mockedLevel.setDificultyLevel(1);
		mockedLevel.setTimeAvailableToAnswer(15);
	}

	@Test
	@Override
	public void create() {
		Assert.assertNotNull("level should not be null",
				levelService.create(mockedLevel));
	}

	@Test
	@Override
	public void delete() {

		final Level level = levelService.create(mockedLevel);
		Assert.assertNotNull("level should not be null", level);
		Assert.assertNotNull("level should not be null", level.getId());
		// It should be found
		Assert.assertNotNull("level should not be null",
				levelService.find(level.getId()));

		levelService.delete(level.getId());
		// It should not be found
		Assert.assertNull("level should be null",
				levelService.find(level.getId()));

	}

	@Test
	@Override
	public void update() {
		Level level = levelService.create(mockedLevel);
		Assert.assertNotNull("level should not be null", level);
		Assert.assertNotNull("level should not be null", level.getId());
		level.setDificultyLevel(2);

		levelService.update(level);
		
		final Level levelUpdated = levelService.find(level.getId());
		Assert.assertNotNull("levelUpdated should not be null", levelUpdated);
		Assert.assertNotNull("levelUpdated should not be null", levelUpdated.getId());
		Assert.assertEquals(level.getId(), levelUpdated.getId());
		Assert.assertEquals(levelUpdated.getDificultyLevel(),2);
	}

	@Test
	@Override
	public void find() {
		final Level level = levelService.create(mockedLevel);
		Assert.assertNotNull("level should not be null", level);
		Assert.assertNotNull("level should not be null", level.getId());
		// It should be found
		Assert.assertNotNull("level should not be null",
				levelService.find(level.getId()));
	}

	@Test
	@Override
	public void getAll() {
		Assert.assertTrue(levelService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		Assert.assertTrue(levelService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		Assert.assertTrue(levelService.getAll().size() >= 5);
	}

}
