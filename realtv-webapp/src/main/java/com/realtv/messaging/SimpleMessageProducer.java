package com.realtv.messaging;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("producer")
public class SimpleMessageProducer {

	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("jmsTopicTemplate")
	private JmsTemplate jmsTopicTemplate;

	protected int numberOfMessages = 100;

	public void convertAndSendMessage(String destination, String message) {
		jmsTemplate.convertAndSend(destination, message);
	}

	public void convertAndSendTopic(String notification) {
		jmsTopicTemplate.convertAndSend("test.topic", notification);
	}

	public void sendMessages() throws JMSException {

		for (int i = 0; i < numberOfMessages; ++i) {

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
