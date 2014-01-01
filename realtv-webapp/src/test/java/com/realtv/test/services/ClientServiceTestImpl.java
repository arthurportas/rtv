package com.realtv.test.services;

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
import com.realtv.services.interfaces.IClientService;
import com.realtv.test.services.interfaces.IClientServiceTest;

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
public class ClientServiceTestImpl implements IClientServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(ClientServiceTestImpl.class);
	@Autowired
	private IClientService clientService;

	private Client mockedClient;
	
	private ClientHistory mockedClientHistory;

	@Before
	public void setup() {
		mockedClient = new Client();
		mockedClient.setMobileID("mobileID");
		
		mockedClientHistory = new ClientHistory();
		mockedClientHistory.setNumGamesCompleted(3);
		mockedClientHistory.setNumRightanswers(30);
		mockedClientHistory.setNumWrongAnswers(3);
		
		mockedClient.setClientHistory(mockedClientHistory);
	}

	@Test
	@Override
	public void findAllClientsNamedQuery() {
		slf4jLogger.info("==findAllClientsNamedQuery()==");
		List<Client> clients = clientService.findAllNamedQuery();
		assertNotNull("clients should not be null", clients);
		assertEquals(59, clients.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("client should not be null",
				clientService.create(mockedClient));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Client client = clientService.create(mockedClient);
		assertNotNull("client should not be null", client);
		assertNotNull("client should not be null", client.getId());
		// It should be found
		assertNotNull("client should not be null",
				clientService.find(client.getId()));

		clientService.delete(client.getId());
		// It should not be found
		assertNull("client should be null",
				clientService.find(client.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		Client client = clientService.create(mockedClient);
		assertNotNull("client should not be null", client);
		assertNotNull("client should not be null", client.getId());
		client.setMobileID("mobileId");

		clientService.update(client);
		final Client clientUpdated = clientService.find(client.getId());
		assertNotNull("clientUpdated should not be null", clientUpdated);
		assertNotNull("clientUpdated should not be null",
				clientUpdated.getId());
		assertEquals(client.getId(), clientUpdated.getId());
		assertTrue(clientUpdated.getMobileID().equals("mobileId"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Client client = clientService.create(mockedClient);
		assertNotNull("client should not be null", client);
		assertNotNull("client should not be null", client.getId());
		// It should be found
		assertNotNull("client should not be null",
				clientService.find(client.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(clientService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		assertTrue(clientService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(clientService.getAll().size() >= 30);
	}

	@Test
	@Override
	public void testClientHistory() {
		slf4jLogger.info("==testCLientHistory() ==");
		final Client client = clientService.create(mockedClient);
		assertNotNull("client should not be null", client);
		assertNotNull("client should not be null", client.getId());
		assertNotNull("clientHistory should not be null",
				client.getClientHistory());
		assertEquals(client.getClientHistory().getId(), mockedClientHistory.getId());
		assertEquals(3, client.getClientHistory().getNumGamesCompleted());
		assertEquals(30, client.getClientHistory().getNumRightanswers());
		assertEquals(3, client.getClientHistory().getNumWrongAnswers());
	}
}
