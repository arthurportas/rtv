package com.realtv.test.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

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
import com.realtv.services.ClientHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ClientHistoryServiceTestImpl implements ClientHistoryServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(ClientHistoryServiceTestImpl.class);
	@Autowired
	private ClientHistoryService clientHistoryService;

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
		Assert.assertNotNull("clientsHistory should not be null", clientsHistory);
		Assert.assertEquals(1, clients.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("clientHistory should not be null",
				clientHistoryService.create(mockedClientHistory));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final ClientHistory clientHistory = clientHistoryService.create(mockedClientHistory);
		Assert.assertNotNull("clientHistory should not be null", clientHistory);
		Assert.assertNotNull("clientHistory should not be null", clientHistory.getId());
		// It should be found
		Assert.assertNotNull("clientHistory should not be null",
				clientHistoryService.find(clientHistory.getId()));

		clientHistoryService.delete(clientHistory.getId());
		// It should not be found
		Assert.assertNull("clientHistory should be null",
				clientHistoryService.find(clientHistory.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		ClientHistory clientHistory = clientHistoryService.create(mockedClientHistory);
		Assert.assertNotNull("clientHistory should not be null", clientHistory);
		Assert.assertNotNull("clientHistory should not be null", clientHistory.getId());
		clientHistory.setNumGamesCompleted(2);

		clientHistoryService.update(clientHistory);
		final ClientHistory clientHistoryUpdated = clientHistoryService.find(clientHistory.getId());
		Assert.assertNotNull("clientHistoryUpdated should not be null", clientHistoryUpdated);
		Assert.assertNotNull("clientHistoryUpdated should not be null",
				clientHistoryUpdated.getId());
		Assert.assertEquals(clientHistory.getId(), clientHistoryUpdated.getId());
		Assert.assertEquals(2, clientHistoryUpdated.getNumGamesCompleted());
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final ClientHistory clientHistory = clientHistoryService.create(mockedClientHistory);
		Assert.assertNotNull("clientHistory should not be null", clientHistory);
		Assert.assertNotNull("clientHistory should not be null", clientHistory.getId());
		// It should be found
		Assert.assertNotNull("clientHistory should not be null",
				clientHistoryService.find(clientHistory.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(clientHistoryService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		Assert.assertTrue(clientHistoryService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(clientHistoryService.getAll().size() >= 1);
	}
}
