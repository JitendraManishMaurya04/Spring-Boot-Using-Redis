package com.in.myapp.redis.receiver;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventConsumer implements MessageListener {

	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.info("Consumer Event {}",message);
		
	}
	
	

}
