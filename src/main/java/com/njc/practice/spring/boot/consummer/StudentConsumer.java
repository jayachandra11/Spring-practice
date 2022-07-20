package com.njc.practice.spring.boot.consummer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.njc.practice.spring.boot.dto.StudentDTO;

@ResponseBody
public class StudentConsumer {
	Logger logger =  LoggerFactory.getLogger(StudentConsumer.class);

	public ResponseEntity<String> sendStudentSaveRequest() {
		
		String url = "localhost:8080/njc/student/save";
		StudentDTO student = new StudentDTO();
		student.setName("ABC");
		student.setStudentId(1234);
		HttpEntity<StudentDTO> request = new HttpEntity<>(student);
		RestTemplate resttemplate = new RestTemplate();
		ResponseEntity<String> response;
		try {
		response = resttemplate.exchange(url,  HttpMethod.POST, request, String.class);
		}
		catch(HttpStatusCodeException exp) {
			logger.error(exp.getMessage());
			response = ResponseEntity.status(exp.getStatusCode()).headers(exp.getResponseHeaders()).body(exp.getResponseBodyAsString());
		}
		return response;
	}

}
