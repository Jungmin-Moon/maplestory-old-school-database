package com.artaleDB.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.artaleDB.dto.UserSearchQueryBoss;
import com.artaleDB.dto.UserSearchQueryDropsBoss;
import com.artaleDB.dto.UserSearchQueryDropsMob;
import com.artaleDB.dto.UserSearchQueryEquipment;
import com.artaleDB.dto.UserSearchQueryMob;

@Component
public class KafkaSender {

	//KafkaTemplates for each type of event
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplateLinkClicks;
	
	@Autowired
	private KafkaTemplate<String, UserSearchQueryMob> kafkaTemplateMobSearch;
	
	@Autowired
	private KafkaTemplate<String, UserSearchQueryBoss> kafkaTemplateBossSearch;
	
	@Autowired
	private KafkaTemplate<String, UserSearchQueryEquipment> kafkaTemplateEquipmentSearch;
	
	@Autowired
	private KafkaTemplate<String, UserSearchQueryDropsMob> kafkaTemplateMobDropSearch;
	
	@Autowired
	private KafkaTemplate<String, UserSearchQueryDropsBoss> kafkaTemplateBossDropSearch;
	
	/*
	 * Individual send messages for each type of potential event
	 * Did not create a single generic method to avoid parameterizing them in each individual controller
	 */
	public void sendMessageLinkClick(String topicName,String key, String msg) {
		kafkaTemplateLinkClicks.send(topicName, key, msg);
	}
	
	public void sendMessageMobSearch(String topicName, String key, UserSearchQueryMob uSearchMob) {
		kafkaTemplateMobSearch.send(topicName, key, uSearchMob);
	}
	
	public void sendMessageBossSearch(String topicName, String key, UserSearchQueryBoss uSearchBoss) {
		kafkaTemplateBossSearch.send(topicName, key, uSearchBoss);
	}
	
	public void sendMessageEquipmentSearch(String topicName, String key, UserSearchQueryEquipment uSearchEquipment) {
		kafkaTemplateEquipmentSearch.send(topicName, key, uSearchEquipment);
	}
	
	public void sendMessageMobDropSearch(String topicName, String key, UserSearchQueryDropsMob uSearchDropsMob) {
		kafkaTemplateMobDropSearch.send(topicName, key, uSearchDropsMob);
	}
	
	public void sendMessageBossDropSearch(String topicName, String key, UserSearchQueryDropsBoss uSearchDropsBoss) {
		kafkaTemplateBossDropSearch.send(topicName, key, uSearchDropsBoss);
	}
	
	
	
}
