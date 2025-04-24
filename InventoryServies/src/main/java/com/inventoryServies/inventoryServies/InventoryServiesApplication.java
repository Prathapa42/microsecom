package com.inventoryServies.inventoryServies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiesApplication.class, args);
	}

}
