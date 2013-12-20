/**
 * 
 */
package com.realtv.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Portas
 * @date 21/12/2013
 */
//this one if for QUEUE
@Component("asyncReceiver")
public class AsyncReceiver {
	
	@Autowired
	private NotificationRegistry registry;

	public void receiveMessage(String notification) {
		registry.registerNotification(notification);
	}
}
