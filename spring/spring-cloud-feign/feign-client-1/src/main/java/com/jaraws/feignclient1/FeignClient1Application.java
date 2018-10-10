package com.jaraws.feignclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // Spring scans for feign client annotation and provides the runtime implementation for it.
@SpringBootApplication
@EnableDiscoveryClient
public class FeignClient1Application{

	public static void main(String[] args) {
		SpringApplication.run(FeignClient1Application.class, args);
	}
	

}
