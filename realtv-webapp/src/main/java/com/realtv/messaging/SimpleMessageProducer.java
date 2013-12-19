package com.realtv.messaging;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SimpleMessageProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	protected int numberOfMessages = 100;

	
	public void sendMessages() throws JMSException {

		
		final int j = 0;
		for (  int i = 0; i < numberOfMessages; ++i) {

		
			final StringBuilder payload = new StringBuilder();

			payload.append("Message [").append(i).append("] sent at: ")
					.append(new Date());

			jmsTemplate.send(new MessageCreator() {

				public Message createMessage(Session session)
						throws JMSException {

					TextMessage message = session.createTextMessage(payload
							.toString());
					
					return (Message) message;

				}

			});

		}

	}
}
