/**
 * 
 */
package com.realtv.messaging;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Portas
 * @date 21/12/2013
 */
@Component("notificationRegistry")
public class NotificationRegistry {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(NotificationRegistry.class);

	private List<String> receivedNotifications = new ArrayList<String>();

	public List<String> getReceivedNotifications() {
		slf4jLogger.info("==List<String> getReceivedNotifications()==");
		slf4jLogger.debug("==Async consumer has ->" +receivedNotifications.size() +", messages stored. ==");
		return receivedNotifications;
	}

	public void registerNotification(String notification) {
		slf4jLogger.info("==registerNotification(String notification)==");
		receivedNotifications.add(notification);
		slf4jLogger.debug("==Message arrived...registering==");	
		slf4jLogger.debug("==Async consumer has ->" +receivedNotifications.size() +", messages stored. ==");		
	}

	public void clear() {
		slf4jLogger.info("==clear()==");
		receivedNotifications.clear();
	}
}
