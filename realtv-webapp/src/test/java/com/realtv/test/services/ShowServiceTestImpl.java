package com.realtv.test.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.realtv.domain.ClientHistory;
import com.realtv.domain.Show;
import com.realtv.services.interfaces.IShowService;
import com.realtv.test.services.interfaces.IShowServiceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ShowServiceTestImpl implements IShowServiceTest {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(ShowServiceTestImpl.class);

	@Autowired
	private IShowService showService;

	@PersistenceContext
	protected EntityManager em;

	private Show mockedShow;

	private ClientHistory mockedClientHistory;	
	private ArrayList<ClientHistory> clientsHistory;
	
	/*Properties Injected*/
	@Value("${SHOW.ALL.DEMO}")
	private String SHOW_ALL_DEMO;
	
	@Value("${SHOW.ALL.REAL.TIME}")
	private String SHOW_ALL_REAL_TIME;
	
	
	@Mock
	private Show _mockedShow;

	@Before
	public void setup() {
		mockedShow = new Show();
		mockedShow.setBeginning(Calendar.getInstance().getTime());
		
		mockedClientHistory = new ClientHistory();
		mockedClientHistory.setNumGamesCompleted(2);
		mockedClientHistory.setNumRightanswers(40);
		mockedClientHistory.setNumWrongAnswers(5);
		mockedClientHistory.setTimeSpentPlaying(1388606491402L);
		
		clientsHistory = new ArrayList<ClientHistory>();
		clientsHistory.add(mockedClientHistory);
		
		mockedShow.setClientsHistory(clientsHistory);
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() {
		showService = null;
		mockedShow = null;
		_mockedShow = null;
		clientsHistory = null;
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("show should not be null", showService.create(mockedShow));
		
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Show show = showService.create(mockedShow);
		assertNotNull("show should not be null", show);
		assertNotNull("show should not be null", show.getId());
		// It should be found
		assertNotNull("show should not be null", showService.find(show.getId()));

		showService.delete(show.getId());
		// It should not be found
		assertNull("show should be null", showService.find(show.getId()));
	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		Show show = showService.create(mockedShow);
		assertNotNull("show should not be null", show);
		assertNotNull("show should not be null", show.getId());
		show.setName("show updated");

		showService.update(show);
		final Show showUpdated = showService.find(show.getId());
		assertNotNull("showUpdated should not be null", showUpdated);
		assertNotNull("showUpdated should not be null", showUpdated.getId());
		assertEquals(show.getId(), showUpdated.getId());
		assertThat(show.getId(), equalTo( showUpdated.getId()));
		assertTrue(showUpdated.getName().equals("show updated"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Show show = showService.create(mockedShow);
		assertNotNull("show should not be null", show);
		assertNotNull("show should not be null", show.getId());
		// It should be found
		assertNotNull("show should not be null", showService.find(show.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(showService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		assertTrue(showService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(showService.getAll().size() >= 11);
		assertNotNull("show should not be null", mockedShow.toJson());
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
		assertEquals(res, 1);
	}
	
	@Test
	@Override
	public void testClientHistory() {
		slf4jLogger.info("==testClientHistory()==");
		assertNotNull("show should not be null", mockedShow.getClientsHistory());
		assertEquals(1, mockedShow.getClientsHistory().size());
		assertEquals(2, mockedShow.getClientsHistory().get(0).getNumGamesCompleted());
		assertEquals(40, mockedShow.getClientsHistory().get(0).getNumRightanswers());
		assertEquals(5, mockedShow.getClientsHistory().get(0).getNumWrongAnswers());
		assertEquals(1388606491402L, mockedShow.getClientsHistory().get(0).getTimeSpentPlaying());
	}
	
	@Test
	@Override
	public void showAllDemoShowNativeQuery() {
		slf4jLogger.info("==showAllDemoShowNativeQuery()==");
		Query query = em
				.createNativeQuery(SHOW_ALL_DEMO, Show.class);
		java.util.List<Object> list = query.getResultList();
		assertNotNull("list should not be null", list);

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			slf4jLogger.debug("==SHOW==");
			Show show = (Show) iterator.next();
			slf4jLogger.debug(show.toString());
		}
	}
	
	@Test
	@Override
	public void showAllRealTimeShowNativeQuery() {
		slf4jLogger.info("==showAllRealTimeShowNativeQuery()==");
		Query query = em
				.createNativeQuery(SHOW_ALL_REAL_TIME, Show.class);
		java.util.List<Object> list = query.getResultList();
		assertNotNull("list should not be null", list);

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			slf4jLogger.debug("==SHOW==");
			Show show = (Show) iterator.next();
			slf4jLogger.debug(show.toString());
		}
	}
}
