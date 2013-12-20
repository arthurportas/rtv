/**
 * 
 */
package com.realtv.messaging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Arthur Portas
 * @date 21/12/2013
 */
@Component("notificationRegistry")
public class NotificationRegistry {
	
	private List<String> receivedNotifications = new ArrayList<String>();
    
    public List<String> getReceivedNotifications() {
            return receivedNotifications;
    }
    
    public void registerNotification(String notification) {
            receivedNotifications.add(notification);
    }
    
    public void clear() {
            receivedNotifications.clear();
    }
}
