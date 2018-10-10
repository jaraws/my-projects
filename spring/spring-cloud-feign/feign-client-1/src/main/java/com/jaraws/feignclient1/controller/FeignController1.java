package com.jaraws.feignclient1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaraws.feignclient1.model.Student;
import com.jaraws.feignclient1.service.StudentService;

@RestController
@RequestMapping("/student")
public class FeignController1 {

	@Autowired
	StudentService service;
	
	@GetMapping("/list")
	public @ResponseBody List<Student> getStudents(){
		System.out.println("Feign client called");
		return service.getStudents();
	}
	
	
}
