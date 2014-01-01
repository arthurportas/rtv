package com.realtv.test.services;

import java.util.ArrayList;
import java.util.Calendar;

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
import com.realtv.services.interfaces.IShowTypeService;
import com.realtv.test.services.interfaces.IShowTypeServiceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ShowTypeServiceTestImpl implements IShowTypeServiceTest {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(ShowTypeServiceTestImpl.class);
	
	@Autowired
	private IShowTypeService showTypeService;

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
		assertNotNull("showType should not be null",
				showTypeService.create(mockedShowType));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final ShowType showType = showTypeService.create(mockedShowType);
		assertNotNull("showType should not be null", showType);
		assertNotNull("showType should not be null", showType.getId());
		// It should be found
		assertNotNull("showType should not be null",
				showTypeService.find(showType.getId()));

		showTypeService.delete(showType.getId());
		// It should not be found
		assertNull("showType should be null",
				showTypeService.find(showType.getId()));
	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		ShowType showType = showTypeService.create(mockedShowType);
		assertNotNull("showType should not be null", showType);
		assertNotNull("showType should not be null", showType.getId());
		showType.setDescription("showType updated");

		showTypeService.update(showType);
		final ShowType showTypeUpdated = showTypeService.find(showType.getId());
		assertNotNull("showTypeUpdated should not be null",
				showTypeUpdated);
		assertNotNull("showTypeUpdated should not be null",
				showTypeUpdated.getId());
		assertEquals(showType.getId(), showTypeUpdated.getId());
		assertTrue(showTypeUpdated.getDescription().equals(
				"showType updated"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final ShowType showType = showTypeService.create(mockedShowType);
		assertNotNull("showType should not be null", showType);
		assertNotNull("showType should not be null", showType.getId());
		// It should be found
		assertNotNull("showType should not be null",
				showTypeService.find(showType.getId()));
		assertNotNull("shows should not be null",
				showTypeService.getAll().get(0).getShows());
		assertEquals(showTypeService.getAll().get(0).getShows().size(), 11);
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(showTypeService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		assertTrue(showTypeService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(showTypeService.getAll().size() >= 2);
	}
}
