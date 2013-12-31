package com.realtv.test.services;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.realtv.domain.Show;
import com.realtv.services.ShowService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ShowServiceTestImpl implements ShowServiceTest {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(ShowServiceTestImpl.class);

	@Autowired
	private ShowService showService;

	@PersistenceContext
	protected EntityManager em;

	private Show mockedShow;

	@Before
	public void setup() {
		mockedShow = new Show();
		mockedShow.setBeginning(Calendar.getInstance().getTime());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("show should not be null",
				showService.create(mockedShow));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Show show = showService.create(mockedShow);
		Assert.assertNotNull("show should not be null", show);
		Assert.assertNotNull("show should not be null", show.getId());
		// It should be found
		Assert.assertNotNull("show should not be null",
				showService.find(show.getId()));

		showService.delete(show.getId());
		// It should not be found
		Assert.assertNull("show should be null", showService.find(show.getId()));
	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		Show show = showService.create(mockedShow);
		Assert.assertNotNull("show should not be null", show);
		Assert.assertNotNull("show should not be null", show.getId());
		show.setName("show updated");

		showService.update(show);
		final Show showUpdated = showService.find(show.getId());
		Assert.assertNotNull("showUpdated should not be null", showUpdated);
		Assert.assertNotNull("showUpdated should not be null",
				showUpdated.getId());
		Assert.assertEquals(show.getId(), showUpdated.getId());
		Assert.assertTrue(showUpdated.getName().equals("show updated"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Show show = showService.create(mockedShow);
		Assert.assertNotNull("show should not be null", show);
		Assert.assertNotNull("show should not be null", show.getId());
		// It should be found
		Assert.assertNotNull("show should not be null",
				showService.find(show.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(showService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		Assert.assertTrue(showService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(showService.getAll().size() >= 11);
		Assert.assertNotNull("show should not be null", mockedShow.toJson());
		slf4jLogger.debug(" mockedShow.toJson()->" + mockedShow.toJson());
	}

	@Test
	@Override
	public void insertShowNativeQuery() {
		slf4jLogger.info("==insertShowNativeQuery()==");
		Query query = em
				.createNativeQuery("INSERT INTO Show (id, name, beginning) "
						+ " VALUES(?,?,?)");
		query.setParameter(1, 100);
		query.setParameter(2, "Quem Quer Ser Milionário.");
		query.setParameter(3, "2012-12-26 05:22:30");
		int res = query.executeUpdate();
		Assert.assertEquals(res, 1);
	}
}
