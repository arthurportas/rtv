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
@Component("asyncTopicReceiver")
public class AsynTopicConsumer2 {

	@Autowired
    private NotificationRegistry registry;
    
    public void receive(String notification) {
        registry.registerNotification(notification);
    }

}
