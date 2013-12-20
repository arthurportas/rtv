package com.realtv.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("consumer")
public class SimpleMessageConsumer {

	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;

	public String receive() {
		return (String) jmsTemplate.receiveAndConvert("test.sync.queue");
	}
}
