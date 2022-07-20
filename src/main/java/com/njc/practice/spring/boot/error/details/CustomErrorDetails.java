package com.njc.practice.spring.boot.error.details;

import java.time.LocalDate;

public class CustomErrorDetails {

	private LocalDate timestamp;
	private  String message;
	private String errorDetails;
	public CustomErrorDetails(LocalDate timestamp, String message, String errorDetails) {
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

}
