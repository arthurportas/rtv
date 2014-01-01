package com.realtv.test.messaging;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.realtv.messaging.NotificationRegistry;
import com.realtv.messaging.SimpleMessageProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml" })
public class TestAsyncMessaging {

	@Autowired
	private SimpleMessageProducer producer;
	
	@Autowired
    private NotificationRegistry registry;
	
	@Test
	public void testAsynchronizedReceiving() throws InterruptedException{
		
		producer.convertAndSendMessage("test.async.queue", "notification");
		Thread.sleep(2000);
	//	assertEquals(1, registry.getReceivedNotifications().size());
     //   assertEquals("notification", registry.getReceivedNotifications().get(0));

	}
	
	@Test
    public void testTopicSending() throws InterruptedException {
       
        producer.convertAndSendTopic("notification");
        Thread.sleep(2000);
        
        //assertEquals(3, registry.getReceivedNotifications().size());/*2+1*/
        //assertEquals("notification", registry.getReceivedNotifications().get(0));
        //assertEquals("notification", registry.getReceivedNotifications().get(1));
    }
}
