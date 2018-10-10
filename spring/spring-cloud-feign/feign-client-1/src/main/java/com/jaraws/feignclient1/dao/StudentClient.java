package com.jaraws.feignclient1.dao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaraws.feignclient1.model.Student;

@FeignClient(name="REST-SERVICE", url="http://localhost:9080") // Base Url of target service, could be replaced with eureka id of target service
public interface StudentClient {

	 @RequestMapping(method = RequestMethod.GET, value = "/student/list")
	    List<Student> getStudents();

}
