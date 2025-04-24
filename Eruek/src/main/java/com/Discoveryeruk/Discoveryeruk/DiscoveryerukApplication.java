package com.Discoveryeruk.Discoveryeruk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryerukApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryerukApplication.class, args);
	}

}
