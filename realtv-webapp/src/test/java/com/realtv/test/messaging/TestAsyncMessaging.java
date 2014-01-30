package com.realtv.test.messaging;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.realtv.facade.ShowFacade;
import com.realtv.messaging.NotificationRegistry;
import com.realtv.messaging.SimpleMessageProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml" })
public class TestAsyncMessaging {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(TestAsyncMessaging.class);
	
	@Autowired
	private SimpleMessageProducer producer;
	
	
}
