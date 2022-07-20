package com.njc.practice.spring.boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njc.practice.spring.boot.dto.EmailRequest;
import com.njc.practice.spring.boot.dto.EmailResponse;
import com.njc.practice.spring.boot.service.EmailService;

@RestController
@RequestMapping("/njc")
public class EmailSchedulerController {

	@Autowired
	EmailService emailService;
	
	@PostMapping("/sendemail")
	public ResponseEntity<EmailResponse> buildEmailJob(@RequestBody @Valid EmailRequest emailRequest) {
		EmailResponse emailResponse = emailService.sendAnEmail(emailRequest);
		if(emailResponse.isSuccess()) {
			return ResponseEntity.status(HttpStatus.OK).body(emailResponse);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
	}
	

}
