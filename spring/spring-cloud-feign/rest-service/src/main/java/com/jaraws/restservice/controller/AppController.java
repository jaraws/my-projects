package com.jaraws.restservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaraws.restservice.config.AppConfig;
import com.jaraws.restservice.model.Student;

@RestController
@RequestMapping(value="/student")
public class AppController {

	@Autowired
	private AppConfig appConfig;
	
	@GetMapping(value="/list",produces="application/json")
	List<Student> getStudents(){
		
		System.out.println("Received request...............");
		int count = 1;
		List<Student> list = new ArrayList<Student>();
		
		System.out.println("Fetching properties from config server...............");
		List<String> names = appConfig.getNames();

		for(String name:names) {
			list.add(new Student(count++,name));
		}
		
		return list;
	}
}


