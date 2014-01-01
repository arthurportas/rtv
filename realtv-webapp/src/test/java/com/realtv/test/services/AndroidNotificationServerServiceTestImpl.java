package com.realtv.test.services;

import java.util.List;

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

import com.realtv.domain.AndroidNotificationServer;
import com.realtv.services.AndroidNotificationServerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AndroidNotificationServerServiceTestImpl implements
		AndroidNotificationServerServiceTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(AndroidNotificationServerServiceTestImpl.class);

	@Autowired
	private AndroidNotificationServerService androidNotificationServerService;

	private AndroidNotificationServer mockedAndroidNotificationServer;

	@Before
	public void setup() {

		mockedAndroidNotificationServer = new AndroidNotificationServer();
		mockedAndroidNotificationServer.setRegisteredEmail("registeredEmail");
		mockedAndroidNotificationServer.setGCMAuthorizationKey("GCMAuthorizationKey");
	}

	@Test
	@Override
	public void findAllAndroidNotificationServersNamedQuery() {
		slf4jLogger.info("==findAllAndroidNotificationServersNamedQuery()==");
		List<AndroidNotificationServer> ans = androidNotificationServerService
				.findAllNamedQuery();
		Assert.assertNotNull("ans should not be null", ans);
		Assert.assertEquals(1, ans.size());
	}

	@Test
	@Override
	public void create() {
		slf4jLogger.info("==create()==");
		Assert.assertNotNull("ans should not be null",
				androidNotificationServerService
						.create(mockedAndroidNotificationServer));
	}

	@Test
	@Override
	public void delete() {
		slf4jLogger.info("==delete()==");
		final AndroidNotificationServer ans = androidNotificationServerService
				.create(mockedAndroidNotificationServer);
		Assert.assertNotNull("ans should not be null", ans);
		Assert.assertNotNull("ans should not be null", ans.getId());
		// It should be found
		Assert.assertNotNull("ans should not be null",
				androidNotificationServerService.find(ans.getId()));

		androidNotificationServerService.delete(ans.getId());
		// It should not be found
		Assert.assertNull("ans should be null",
				androidNotificationServerService.find(ans.getId()));

	}

	@Test
	@Override
	public void update() {
		slf4jLogger.info("==update()==");
		AndroidNotificationServer ans = androidNotificationServerService
				.create(mockedAndroidNotificationServer);
		Assert.assertNotNull("ans should not be null", ans);
		Assert.assertNotNull("ans should not be null", ans.getId());
		ans.setRegisteredEmail("email");

		androidNotificationServerService.update(ans);
		final AndroidNotificationServer ansUpdated = androidNotificationServerService
				.find(ans.getId());
		Assert.assertNotNull("ansUpdated should not be null", ansUpdated);
		Assert.assertNotNull("ansUpdated should not be null",
				ansUpdated.getId());
		Assert.assertEquals(ans.getId(), ansUpdated.getId());
		Assert.assertTrue(ansUpdated.getRegisteredEmail().equals("email"));
	}

	@Test
	@Override
	public void find() {
		slf4jLogger.info("==find()==");
		final AndroidNotificationServer ans = androidNotificationServerService
				.create(mockedAndroidNotificationServer);
		Assert.assertNotNull("ans should not be null", ans);
		Assert.assertNotNull("ans should not be null", ans.getId());
		// It should be found
		Assert.assertNotNull("ans should not be null",
				androidNotificationServerService.find(ans.getId()));
	}

	@Test
	@Override
	public void getAll() {
		slf4jLogger.info("==getAll()==");
		Assert.assertTrue(androidNotificationServerService.getAll().size() > 0);
	}

	@Test
	@Override
	public void findAllNamedQuery() {
		slf4jLogger.info("==findAllNamedQuery()==");
		Assert.assertTrue(androidNotificationServerService.findAllNamedQuery()
				.size() > 0);
	}

	@Test
	@Override
	public void count() {
		slf4jLogger.info("==count()==");
		Assert.assertTrue(androidNotificationServerService.getAll().size() >= 1);
	}

}
