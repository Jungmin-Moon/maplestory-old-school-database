package com.artaleDB.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {
	
	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return new KafkaAdmin(configs);
	}
	
	//Topic to keep track of user site navigation
	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("Link-Click-Events").build();
	}
	
	//Topic to keep track of what users searched for in the Mob search page
	@Bean
	public NewTopic topic2() {
		return TopicBuilder.name("Mob-Search-Choices").build();
	}
	
	//Topic to keep track of what users searched for in the Boss search page
	@Bean
	public NewTopic topic3() {
		return TopicBuilder.name("Boss-Search-Choices").build();
		
	}
	
	//Topic to keep track of what users searched for in the Drops search page 
	@Bean
	public NewTopic topic4() {
		return TopicBuilder.name("Drop-Search-Choices").build();
	}
	
	//Topic to keep track of what users searched for in the Equipment search page
	@Bean
	public NewTopic topic5() {
		return TopicBuilder.name("Equipment-Search-Choices").build();
	}
}
