package com.artaleDB.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafaProducerConfig {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;

	
	//ProducerFactory for events that involve clicking links to navigate through the website
    @Bean
    ProducerFactory<String, String> producerFactoryLinkClicks() {
		Map<String, Object> configProps = new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}
    
	//ProducerFactory created with a generic to allow for the various types of searches that can be done and serialized with JSON
	@Bean
	<T> ProducerFactory<String, T> producerFactorySearch() {
		Map<String, Object> configProps = new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	//The KafkaTemplate for the events that involve clicking links
	@Bean
	KafkaTemplate<String, String> kafkaTemplateLinkClicks() {
		return new KafkaTemplate<>(producerFactoryLinkClicks());
	}
	
	
	//The KafkaTemplate for the events that involve the different searches available
	@Bean
	<T> KafkaTemplate<String, T> kafkaTemplateSearch() {
		return new KafkaTemplate<>(producerFactorySearch());
	}
	
}
