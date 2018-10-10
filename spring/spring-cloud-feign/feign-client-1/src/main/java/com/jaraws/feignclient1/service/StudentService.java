package com.jaraws.feignclient1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaraws.feignclient1.dao.StudentClient;
import com.jaraws.feignclient1.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentClient studentClient;
	
	public List<Student> getStudents(){
		return studentClient.getStudents();
	}
}
