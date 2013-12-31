package com.realtv.test.services;

import java.util.ArrayList;
import java.util.Calendar;

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

import com.realtv.domain.Show;
import com.realtv.domain.ShowType;
import com.realtv.services.ShowTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ShowTypeServiceTestImpl implements ShowTypeServiceTest {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(ShowTypeServiceTestImpl.class);
	
	@Autowired
	private ShowTypeService showTypeService;

	private ShowType mockedShowType;
	private Show mockedShow;
	private ArrayList<Show> shows;

	@Before
	public void setup() {
		mockedShowType = new ShowType();
		mockedShowType.setDescription("description");
		mockedShowType.setMode(1);/* refactor to enum */
		mockedShow = new Show();
		mockedShow.setName("show");
		mockedShow.setBeginning(Calendar.getInstance().getTime());

		mockedShow.setShowType(mockedShowType);

		shows = new ArrayList<Show>();
		shows.add(mockedShow);

		mockedShowType.setShows(shows);
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("showType should not be null",
				showTypeService.create(mockedShowType));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final ShowType showType = showTypeService.create(mockedShowType);
		Assert.assertNotNull("showType should not be null", showType);
		Assert.assertNotNull("showType should not be null", showType.getId());
		// It should be found
		Assert.assertNotNull("showType should not be null",
				showTypeService.find(showType.getId()));

		showTypeService.delete(showType.getId());
		// It should not be found
		Assert.assertNull("showType should be null",
				showTypeService.find(showType.getId()));
	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		ShowType showType = showTypeService.create(mockedShowType);
		Assert.assertNotNull("showType should not be null", showType);
		Assert.assertNotNull("showType should not be null", showType.getId());
		showType.setDescription("showType updated");

		showTypeService.update(showType);
		final ShowType showTypeUpdated = showTypeService.find(showType.getId());
		Assert.assertNotNull("showTypeUpdated should not be null",
				showTypeUpdated);
		Assert.assertNotNull("showTypeUpdated should not be null",
				showTypeUpdated.getId());
		Assert.assertEquals(showType.getId(), showTypeUpdated.getId());
		Assert.assertTrue(showTypeUpdated.getDescription().equals(
				"showType updated"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final ShowType showType = showTypeService.create(mockedShowType);
		Assert.assertNotNull("showType should not be null", showType);
		Assert.assertNotNull("showType should not be null", showType.getId());
		// It should be found
		Assert.assertNotNull("showType should not be null",
				showTypeService.find(showType.getId()));
		Assert.assertNotNull("shows should not be null",
				showTypeService.getAll().get(0).getShows());
		Assert.assertEquals(showTypeService.getAll().get(0).getShows().size(), 11);
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(showTypeService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		Assert.assertTrue(showTypeService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(showTypeService.getAll().size() >= 2);
	}
}
