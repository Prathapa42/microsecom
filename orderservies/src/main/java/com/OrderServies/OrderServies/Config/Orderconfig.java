package com.OrderServies.OrderServies.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Orderconfig {

   @Bean
    @LoadBalanced
    public WebClient.Builder webClient() {
       return WebClient.builder()
               .baseUrl("http://inventoryServies/Api/inventory") // Replace with your actual service URL
               ; // Replace with your actual service URL
   }




}
