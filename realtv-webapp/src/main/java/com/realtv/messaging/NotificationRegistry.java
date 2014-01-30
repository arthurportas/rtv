/**
 * 
 */
package com.realtv.messaging;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.realtv.dto.QuestionDTO;

/**
 * @author Arthur Portas
 * @date 21/12/2013
 */
@Component("notificationRegistry")
public class NotificationRegistry {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(NotificationRegistry.class);

	//service to persi
	private List<String> receivedNotifications = new ArrayList<String>();
	@Autowired
    ConfigurableApplicationContext context;
	@Autowired
	public List<String> getReceivedNotifications() {
		slf4jLogger.info("==List<String> getReceivedNotifications()==");
		//slf4jLogger.debug("==Async consumer has ->" +receivedNotifications.size() +", messages stored. ==");
		return receivedNotifications;
	}

	public void registerNotification(String notification) {
		slf4jLogger.info("==registerNotification(String notification)==");
		receivedNotifications.add(notification);
		slf4jLogger.debug("==Client->Message arrived...registering==");	
		slf4jLogger.debug("==Client->Async consumer has ->" +receivedNotifications.size() +", messages stored. ==");
		slf4jLogger.debug("==Client->Async consumer message ->" +receivedNotifications.get(receivedNotifications.size()-1));
		
		//send answer :)
		
		SimpleMessageProducer producer = context.getBean(SimpleMessageProducer.class);
		producer.convertAndSendMessage("answers.queue", "amazing answer");
	

	}

	public void clear() {
		slf4jLogger.info("==clear()==");
		receivedNotifications.clear();
	}
}
