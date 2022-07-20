package com.njc.practice.spring.boot.exception;

public class StudentNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message) {
		super(message);
	}

}
