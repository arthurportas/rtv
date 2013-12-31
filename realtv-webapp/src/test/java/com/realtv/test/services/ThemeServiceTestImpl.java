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

import com.realtv.domain.Question;
import com.realtv.domain.Theme;
import com.realtv.services.ThemeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ThemeServiceTestImpl implements ThemeServiceTest {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(ThemeServiceTestImpl.class);

	@Autowired
	private ThemeService themeService;

	private Theme mockedTheme;
	private Question mockedQuestion;
	private ArrayList<Question> questions;

	@Before
	public void setup() {
		mockedTheme = new Theme();
		mockedTheme.setTheme("theme");
		mockedTheme.setDescription("description");

		mockedQuestion = new Question();
		mockedQuestion.setQuestion("question");

		questions = new ArrayList<Question>();

		mockedQuestion.setTheme(mockedTheme);

		questions.add(mockedQuestion);

		mockedTheme.setQuestions(questions);
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("theme should not be null",
				themeService.create(mockedTheme));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Theme theme = themeService.create(mockedTheme);
		Assert.assertNotNull("theme should not be null", theme);
		Assert.assertNotNull("theme should not be null", theme.getId());
		// It should be found
		Assert.assertNotNull("theme should not be null",
				themeService.find(theme.getId()));

		themeService.delete(theme.getId());
		// It should not be found
		Assert.assertNull("theme should be null",
				themeService.find(theme.getId()));
	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		Theme theme = themeService.create(mockedTheme);
		Assert.assertNotNull("theme should not be null", theme);
		Assert.assertNotNull("theme should not be null", theme.getId());
		theme.setTheme("theme");

		themeService.update(theme);
		final Theme themeUpdated = themeService.find(theme.getId());
		Assert.assertNotNull("themeUpdated should not be null", themeUpdated);
		Assert.assertNotNull("themeUpdated should not be null",
				themeUpdated.getId());
		Assert.assertEquals(theme.getId(), themeUpdated.getId());
		Assert.assertTrue(themeUpdated.getTheme().equals("theme"));

	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Theme theme = themeService.create(mockedTheme);
		Assert.assertNotNull("theme should not be null", theme);
		Assert.assertNotNull("theme should not be null", theme.getId());
		// It should be found
		Assert.assertNotNull("theme should not be null",
				themeService.find(theme.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(themeService.getAll().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(themeService.getAll().size() >= 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.ThemeServiceTest#findAllOrderedByName()
	 */
	@Test
	@Override
	public void findAllOrderedByName() {
		slf4jLogger.info("==findAllOrderedByName()==");
		List<Theme> themes = themeService.findAllOrderedByName();
		Assert.assertNotNull("theme should not be null", themes);
		/* uses Criteria Builder */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.services.ThemeServiceTest#findByTheme()
	 */
	@Test
	@Override
	public void findByTheme() {
		slf4jLogger.info("==findByTheme()==");
		Theme theme = themeService.getAll().get(0);
		final Theme lookup = themeService.findByTheme(theme.getTheme());
		Assert.assertNotNull("lookup should not be null", lookup);
		Assert.assertEquals(lookup.getId(), theme.getId());

	}
}
