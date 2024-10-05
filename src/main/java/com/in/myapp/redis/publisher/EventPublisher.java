package com.in.myapp.redis.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.myapp.redis.entity.Product;

@RestController
public class EventPublisher {
	
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ChannelTopic channelTopic;
	
	@PostMapping("/publish")
	public String eventPublish(@RequestBody Product product) {
		redisTemplate.convertAndSend(channelTopic.getTopic(), product.toString());
		return "Event Published !!!";
	}

}
