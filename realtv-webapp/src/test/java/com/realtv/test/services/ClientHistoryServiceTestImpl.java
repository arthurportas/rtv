package com.realtv.test.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Client;
import com.realtv.domain.ClientHistory;
import com.realtv.services.interfaces.IClientHistoryService;
import com.realtv.test.services.interfaces.IClientHistoryServiceTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ClientHistoryServiceTestImpl implements IClientHistoryServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(ClientHistoryServiceTestImpl.class);
	@Autowired
	private IClientHistoryService clientHistoryService;

	private ClientHistory mockedClientHistory;
	private Client mockedClient;
	private ArrayList<Client> clients;
	
	@Before
	public void setup() {
		mockedClient = new Client();
		mockedClient.setMobileID("mobileID");
		mockedClient.setClientGCMRegistrationID("clientGCMRegistrationID");
		
		clients = new ArrayList<Client>();
		clients.add(mockedClient);
		
		mockedClientHistory = new ClientHistory();
		mockedClientHistory.setNumGamesCompleted(1);
		mockedClientHistory.setNumRightanswers(15);
		mockedClientHistory.setNumWrongAnswers(0);
		mockedClientHistory.setTimeSpentPlaying(Calendar.getInstance().getTimeInMillis());
		
		mockedClient.setClientHistory(mockedClientHistory);
		mockedClientHistory.setClients(clients);
	}

	@Test
	@Override
	public void findAllClientsHistoryNamedQuery() {
		slf4jLogger.info("==findAllClientsHistoryNamedQuery()==");
		List<ClientHistory> clientsHistory = clientHistoryService.findAllNamedQuery();
		assertNotNull("clientsHistory should not be null", clientsHistory);
		assertEquals(1, clients.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("clientHistory should not be null",
				clientHistoryService.create(mockedClientHistory));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final ClientHistory clientHistory = clientHistoryService.create(mockedClientHistory);
		assertNotNull("clientHistory should not be null", clientHistory);
		assertNotNull("clientHistory should not be null", clientHistory.getId());
		// It should be found
		assertNotNull("clientHistory should not be null",
				clientHistoryService.find(clientHistory.getId()));

		clientHistoryService.delete(clientHistory.getId());
		// It should not be found
		assertNull("clientHistory should be null",
				clientHistoryService.find(clientHistory.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		ClientHistory clientHistory = clientHistoryService.create(mockedClientHistory);
		assertNotNull("clientHistory should not be null", clientHistory);
		assertNotNull("clientHistory should not be null", clientHistory.getId());
		clientHistory.setNumGamesCompleted(2);

		clientHistoryService.update(clientHistory);
		final ClientHistory clientHistoryUpdated = clientHistoryService.find(clientHistory.getId());
		assertNotNull("clientHistoryUpdated should not be null", clientHistoryUpdated);
		assertNotNull("clientHistoryUpdated should not be null",
				clientHistoryUpdated.getId());
		assertEquals(clientHistory.getId(), clientHistoryUpdated.getId());
		assertEquals(2, clientHistoryUpdated.getNumGamesCompleted());
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final ClientHistory clientHistory = clientHistoryService.create(mockedClientHistory);
		assertNotNull("clientHistory should not be null", clientHistory);
		assertNotNull("clientHistory should not be null", clientHistory.getId());
		// It should be found
		assertNotNull("clientHistory should not be null",
				clientHistoryService.find(clientHistory.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(clientHistoryService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		assertTrue(clientHistoryService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(clientHistoryService.getAll().size() >= 1);
	}
}
