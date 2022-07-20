package com.njc.practice.spring.boot.advice;

import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.njc.practice.spring.boot.error.details.CustomErrorDetails;
import com.njc.practice.spring.boot.exception.StudentNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handlerInalidException(MethodArgumentNotValidException ex) {
//		Map<String, String> errorMap = new HashMap<>();
//		ex.getBindingResult().getFieldErrors().forEach(error -> {
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
//		return errorMap;
//	}

//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(StudentNotFoundException.class)
//	public Map<String, String> handlerStudentNotFoundException(StudentNotFoundException ex) {
//		Map<String, String> errorMap = new HashMap<>();
//		errorMap.put("error message", ex.getMessage());
//		return errorMap;
//	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<CustomErrorDetails> handlerStudentNotFoundException(StudentNotFoundException ex) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(LocalDate.now(), ex.getMessage(), ex.getLocalizedMessage());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(customErrorDetails);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomErrorDetails> handlerInalidException(MethodArgumentNotValidException ex) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).
				body(new CustomErrorDetails(LocalDate.now(), "Some required fields are not as expected or missing", ex.getMessage()));
	}
}
