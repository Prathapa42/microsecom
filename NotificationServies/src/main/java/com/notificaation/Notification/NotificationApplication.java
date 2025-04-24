package com.notificaation.Notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}



	@KafkaListener(topics ="${spring.kafka.template.default.topic}" ,
//		 @KafkaListener(topics ="booking")
			groupId = "${spring.kafka.consumer.gruop-id}" )
	public void orderNotices(String message)
	{

		log.info("order to send notification {}"+message);
		try
		{
			ObjectMapper objectMapper = new ObjectMapper();
			OrderplaceEvent bookingEvent = objectMapper.readValue(message, OrderplaceEvent.class);

			log.info("Consumer kafka");
			log.info("Consumer Desirilaztion "+bookingEvent.toString());


		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



}
