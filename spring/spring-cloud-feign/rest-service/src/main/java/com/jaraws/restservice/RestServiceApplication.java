package com.jaraws.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * IMPORTANT:
 * ==============================================================================================
 * 
 * 1. End point to refresh config server to read updated properties from configuration location
 * 		> http://localhost:8020/bus/refresh
 * 2. End point to refresh config server client to read the updated properties from Config server via rabbit Mq
 * 		> http://localhost:9080/actuator/refresh
 * 3. In Spring 2.X only 2 end points from actuator end points are accessible by default. One needs to enable
 * 		 /actuator/refresh end point to make the configuration server client to read the updated properties via
 * 			rabbit mq.
 * 
 * ==============================================================================================
 * @author SWARAJ
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
