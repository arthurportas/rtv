package com.realtv.test.services;

import java.util.ArrayList;
import java.util.List;

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

import com.realtv.domain.AndroidNotificationServer;
import com.realtv.domain.Client;
import com.realtv.services.interfaces.IAndroidNotificationServerService;
import com.realtv.test.services.interfaces.IAndroidNotificationServerServiceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AndroidNotificationServerServiceTestImpl implements
		IAndroidNotificationServerServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(AndroidNotificationServerServiceTestImpl.class);

	@Autowired
	private IAndroidNotificationServerService androidNotificationServerService;

	private AndroidNotificationServer mockedAndroidNotificationServer;
	private Client mockedClient;
	private ArrayList<Client> clients;

	@Before
	public void setup() {

		mockedAndroidNotificationServer = new AndroidNotificationServer();
		mockedAndroidNotificationServer.setRegisteredEmail("registeredEmail");
		mockedAndroidNotificationServer
				.setGCMAuthorizationKey("GCMAuthorizationKey");
		clients = new ArrayList<Client>();
		mockedClient = new Client();
		mockedClient.setMobileID("mobileID");
		mockedClient.setClientGCMRegistrationID("clientGCMRegistrationID");
		clients.add(mockedClient);
		mockedClient
				.setAndroidNotificationServer(mockedAndroidNotificationServer);
		mockedAndroidNotificationServer.setClients(clients);
	}

	@Test
	@Override
	public void findAllAndroidNotificationServersNamedQuery() {
		slf4jLogger.info("==findAllAndroidNotificationServersNamedQuery()==");
		List<AndroidNotificationServer> ans = androidNotificationServerService
				.findAllNamedQuery();
		assertNotNull("ans should not be null", ans);
		assertEquals(1, ans.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		assertNotNull("ans should not be null",
				androidNotificationServerService
						.create(mockedAndroidNotificationServer));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final AndroidNotificationServer ans = androidNotificationServerService
				.create(mockedAndroidNotificationServer);
		assertNotNull("ans should not be null", ans);
		assertNotNull("ans should not be null", ans.getId());
		// It should be found
		assertNotNull("ans should not be null",
				androidNotificationServerService.find(ans.getId()));

		androidNotificationServerService.delete(ans.getId());
		// It should not be found
		assertNull("ans should be null",
				androidNotificationServerService.find(ans.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		final AndroidNotificationServer ans = androidNotificationServerService
				.create(mockedAndroidNotificationServer);
		assertNotNull("ans should not be null", ans);
		assertNotNull("ans should not be null", ans.getId());
		ans.setRegisteredEmail("email");

		androidNotificationServerService.update(ans);
		final AndroidNotificationServer ansUpdated = androidNotificationServerService
				.find(ans.getId());
		assertNotNull("ansUpdated should not be null", ansUpdated);
		assertNotNull("ansUpdated should not be null", ansUpdated.getId());
		assertEquals(ans.getId(), ansUpdated.getId());
		assertTrue(ansUpdated.getRegisteredEmail().equals("email"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final AndroidNotificationServer ans = androidNotificationServerService
				.create(mockedAndroidNotificationServer);
		assertNotNull("ans should not be null", ans);
		assertNotNull("ans should not be null", ans.getId());
		// It should be found
		assertNotNull("ans should not be null",
				androidNotificationServerService.find(ans.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		assertTrue(androidNotificationServerService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		assertTrue(androidNotificationServerService.findAllNamedQuery().size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		assertTrue(androidNotificationServerService.getAll().size() >= 1);
	}

	@Test
	@Override
	public void testClientAssociation() {

		assertNotNull("mockedAndroidNotificationServer should not be null",
				(mockedAndroidNotificationServer));
		assertNotNull("mockedClient should not be null",
				(mockedClient));
		assertEquals(1, mockedAndroidNotificationServer.getClients().size());
		assertEquals(mockedClient.getAndroidNotificationServer().getId(), mockedAndroidNotificationServer.getClients().get(0).getAndroidNotificationServer().getId());

	}

}
