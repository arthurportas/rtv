package com.realtv.test.messaging;

import static org.junit.Assert.*;

import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.realtv.messaging.SimpleMessageConsumer;
import com.realtv.messaging.SimpleMessageProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml" })
public class TestSyncMessaging {

	@Autowired
	private SimpleMessageProducer producer;
	
	@Autowired
	private SimpleMessageConsumer consumer;
	
	@Test
	public void testSyncProducer() throws InterruptedException{
		
		try {
			producer.sendMessages();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
		String receivedNotification = consumer.receive();
		assertNotNull(receivedNotification);
		System.out.println("Received" + receivedNotification);
		
	}
}
