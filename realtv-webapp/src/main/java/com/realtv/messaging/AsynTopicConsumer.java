/**
 * 
 */
package com.realtv.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Portas
 * @date 21/12/2013
 */
@Component("asyncTopicReceiver") //this one simulates clients
public class AsynTopicConsumer {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(AsynTopicConsumer.class);
	
	@Autowired
    private NotificationRegistry registry;
    
    public void receive(String notification) {
    	slf4jLogger.debug("==void receive(String notification)==");
    	slf4jLogger.debug("*******************************");
        registry.registerNotification(notification);
    }

}
