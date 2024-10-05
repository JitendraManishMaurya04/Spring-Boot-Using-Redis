package com.in.myapp.redis;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

//	@Bean
//	public ApplicationRunner applicationRunner(StringRedisTemplate redisTemplate) {
//		return args ->{
//			redisTemplate.opsForValue().set("myName", "Manish");
//			System.out.println("String Operation: "+redisTemplate.opsForValue().get("myName"));
//			
//			redisTemplate.opsForList().leftPushAll("mySampleList", "One","Two","Three","Four","Five");
//			System.out.println("List Left POP Operation: "+redisTemplate.opsForList().leftPop("mySampleList"));
//			System.out.println("List Right POP Operation: "+redisTemplate.opsForList().rightPop("mySampleList"));
//
//			redisTemplate.opsForHash().put("myHash", "key","value");
//			System.out.println("Hash Map Operation: "+redisTemplate.opsForHash().get("myHash","key"));
//
//			redisTemplate.opsForSet().add("mySet", "A", "B", "C", "D");
//			System.out.println("Set Operation, Value Exist: "+redisTemplate.opsForSet().isMember("mySet","A"));
//			System.out.println("Set Operation, Value doesn't Exist: "+redisTemplate.opsForSet().isMember("mySet","E"));
//
//			redisTemplate.opsForZSet().add("myLeaderBoard", "Player-1", 15); //2-2  
//			redisTemplate.opsForZSet().add("myLeaderBoard", "Player-2", 12); //1-3
//			redisTemplate.opsForZSet().add("myLeaderBoard", "Player-3", 66); //4-0
//			redisTemplate.opsForZSet().add("myLeaderBoard", "Player-4", 23); //3-1
//			redisTemplate.opsForZSet().add("myLeaderBoard", "Player-5", 7); //0-4
//			System.out.println("Sorted Set Rank Operation: "+redisTemplate.opsForZSet().rank("myLeaderBoard","Player-2"));
//			System.out.println("Sorted Set Reverse Rank Operation: "+redisTemplate.opsForZSet().reverseRank("myLeaderBoard","Player-2"));
//			System.out.println("Sorted Set Range Operation: "+redisTemplate.opsForZSet().range("myLeaderBoard",0,2));
//			System.out.println("Sorted Set Reverse Range Operation: "+redisTemplate.opsForZSet().reverseRange("myLeaderBoard",0,2));
//
//			
//		};
//	}
}
