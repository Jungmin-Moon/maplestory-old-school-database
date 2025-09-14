package com.artaleDB.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.artaleDB.dto.UserSearchQueryBoss;
import com.artaleDB.dto.UserSearchQueryMob;

@Component
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplateLinkClicks;
	
	@Autowired
	private KafkaTemplate<String, UserSearchQueryMob> kafkaTemplateMobSearch;
	
	@Autowired
	private KafkaTemplate<String, UserSearchQueryBoss> kafkaTemplateBossSearch;
	
	public void sendMessageLinkClick(String topicName,String key, String msg) {
		kafkaTemplateLinkClicks.send(topicName, key, msg);
	}
	
	public void sendMessageMobSearch(String topicName, String key, UserSearchQueryMob uSearchMob) {
		kafkaTemplateMobSearch.send(topicName, key, uSearchMob);
	}
	
	public void sendMessageBossSearch(String topicName, String key, UserSearchQueryBoss uSearchBoss) {
		kafkaTemplateBossSearch.send(topicName, key, uSearchBoss);
	}
	
	
}
