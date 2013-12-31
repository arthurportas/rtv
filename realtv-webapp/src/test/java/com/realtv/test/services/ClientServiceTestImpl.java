package com.realtv.test.services;

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
import com.realtv.services.ClientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ClientServiceTestImpl implements ClientServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(ClientServiceTestImpl.class);
	@Autowired
	private ClientService clientService;

	private Client mockedClient;

	@Before
	public void setup() {
		mockedClient = new Client();
		mockedClient.setMobileID("mobileID");
	}

	@Test
	@Override
	public void findAllClientsNamedQuery() {
		slf4jLogger.info("==findAllClientsNamedQuery()==");
		List<Client> clients = clientService.findAllNamedQuery();
		Assert.assertNotNull("clients should not be null", clients);
		Assert.assertEquals(59, clients.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("client should not be null",
				clientService.create(mockedClient));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final Client client = clientService.create(mockedClient);
		Assert.assertNotNull("client should not be null", client);
		Assert.assertNotNull("client should not be null", client.getId());
		// It should be found
		Assert.assertNotNull("client should not be null",
				clientService.find(client.getId()));

		clientService.delete(client.getId());
		// It should not be found
		Assert.assertNull("client should be null",
				clientService.find(client.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		Client client = clientService.create(mockedClient);
		Assert.assertNotNull("client should not be null", client);
		Assert.assertNotNull("client should not be null", client.getId());
		client.setMobileID("mobileId");

		clientService.update(client);
		final Client clientUpdated = clientService.find(client.getId());
		Assert.assertNotNull("clientUpdated should not be null", clientUpdated);
		Assert.assertNotNull("clientUpdated should not be null",
				clientUpdated.getId());
		Assert.assertEquals(client.getId(), clientUpdated.getId());
		Assert.assertTrue(clientUpdated.getMobileID().equals("mobileId"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final Client client = clientService.create(mockedClient);
		Assert.assertNotNull("client should not be null", client);
		Assert.assertNotNull("client should not be null", client.getId());
		// It should be found
		Assert.assertNotNull("client should not be null",
				clientService.find(client.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(clientService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		Assert.assertTrue(clientService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(clientService.getAll().size() >= 30);
	}
}
