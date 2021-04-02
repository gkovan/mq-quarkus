package com.example.quarkus.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.quarkus.exceptions.AppException;

@ApplicationScoped
public class MQService {
	
	public MQService() {
		super();
		// TODO Auto-generated constructor stub
	}


    @Inject
	private MyJMSTemplate jmsTemplate;
	
	
	public void sendHelloWorld() {
		
		final Logger LOG = LoggerFactory.getLogger(MQService.class);

		try {
			//MyJMSTemplate jmsTemplate = new MyJMSTemplate();
			String helloWorld = "Hello World!";
			jmsTemplate.send();
			//jmsTemplate.convertAndSend("DEV.QUEUE.1", helloWorld);
			LOG.debug("Successfully Sent message: {} to the queue", helloWorld);
		} catch (Exception ex) {
			throw new AppException("MQAPP001", "Error sending message to the queue.", ex);
		}
	}

}
