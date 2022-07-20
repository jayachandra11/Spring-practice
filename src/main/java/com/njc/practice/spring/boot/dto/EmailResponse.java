package com.njc.practice.spring.boot.dto;

public class EmailResponse {

	private boolean success;

	private String jobId;

	private String jobGroup;

	private String message;

	public boolean isSuccess() {
		return success;
	}

	public EmailResponse(boolean success, String message) { 
		super();
		this.success = success;
		this.message = message;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getJobId() {
		return jobId;
	}

	public EmailResponse(boolean success, String jobId, String jobGroup, String message) {
		super();
		this.success = success;
		this.jobId = jobId;
		this.jobGroup = jobGroup;
		this.message = message;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
