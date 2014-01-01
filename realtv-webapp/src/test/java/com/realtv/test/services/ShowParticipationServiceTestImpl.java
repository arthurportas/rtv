package com.realtv.test.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.ShowParticipation;
import com.realtv.services.interfaces.IShowParticipationService;
import com.realtv.test.services.interfaces.IShowParticipationServiceTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ShowParticipationServiceTestImpl implements IShowParticipationServiceTest {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(ShowParticipationServiceTestImpl.class);

	@Autowired
	private IShowParticipationService showParticipationService;

	@PersistenceContext
	protected EntityManager em;

	private ShowParticipation mockedShowParticipation;

	@Before
	public void setup() {
	
		mockedShowParticipation = new ShowParticipation();
		mockedShowParticipation.setLastBeginPlaying(Calendar.getInstance().getTime());
		mockedShowParticipation.setNumGamesCompleted(3);
		mockedShowParticipation.setNumRightAnswers(32);
		mockedShowParticipation.setNumWrongAnswers(4);
		mockedShowParticipation.setTimeSpentPlaying(Calendar.getInstance().getTimeInMillis());
	}

	@After
	public void tearDown() {
		mockedShowParticipation = null;
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("showParticipation should not be null", showParticipationService.create(mockedShowParticipation));

	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final ShowParticipation showParticipation = showParticipationService.create(mockedShowParticipation);
		assertNotNull("showParticipation should not be null", showParticipation);
		assertNotNull("showParticipation should not be null", showParticipation.getId());
		// It should be found
		assertNotNull("showParticipation should not be null", showParticipationService.find(showParticipation.getId()));

		showParticipationService.delete(showParticipation.getId());
		// It should not be found
		assertNull("show should be null", showParticipationService.find(showParticipation.getId()));
	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		final ShowParticipation showParticipation = showParticipationService.create(mockedShowParticipation);
		assertNotNull("showParticipation should not be null", showParticipation);
		assertNotNull("showParticipation should not be null", showParticipation.getId());
		showParticipation.setLastBeginPlaying(Calendar.getInstance().getTime());

		
		showParticipationService.update(showParticipation);
		final ShowParticipation showParticipationUpdated = showParticipationService.find(showParticipation.getId());
		assertNotNull("showParticipationUpdated should not be null", showParticipationUpdated);
		assertNotNull("showParticipationUpdated should not be null", showParticipationUpdated.getId());
		assertEquals(showParticipation.getId(), showParticipationUpdated.getId());
		assertThat(showParticipation.getId(), equalTo( showParticipationUpdated.getId()));
		
		//see how to compare dates
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final ShowParticipation showParticipation = showParticipationService.create(mockedShowParticipation);
		assertNotNull("showParticipation should not be null", showParticipation);
		assertNotNull("showParticipation should not be null", showParticipation.getId());
		// It should be found
		assertNotNull("showParticipation should not be null", showParticipationService.find(showParticipation.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(showParticipationService.getAll().size() >= 2);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		assertTrue(showParticipationService.findAllNamedQuery().size() >= 2);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(showParticipationService.getAll().size() >= 2);
	}

	@Test
	@Ignore
	@Override
	public void insertShowParticipationNativeQuery() {
		slf4jLogger.info("==insertShowParticipationNativeQuery()==");
		Query query = em
				.createNativeQuery("INSERT INTO ShowParticipation (id, name, beginning) "
						+ " VALUES(?,?,?)");
		query.setParameter(1, 100);
		query.setParameter(2, "Quem Quer Ser Milionário.");
		query.setParameter(3, "2012-12-26 05:22:30");
		int res = query.executeUpdate();
		assertEquals(res, 1);
	}
}
