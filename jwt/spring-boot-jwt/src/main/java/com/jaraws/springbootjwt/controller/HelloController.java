package com.jaraws.springbootjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController{
	
	@GetMapping
	public String sayHello() {
		return "Hello World ";
	}
}