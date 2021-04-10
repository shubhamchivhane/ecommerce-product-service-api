package com.ecom.exception;

import java.util.Date;

public class RestAPIExceptionInfo {

	private Date timestamps;

	private final String message;

	private final String details;

	public RestAPIExceptionInfo() {
		message = null;
		details = null;
	}

	public RestAPIExceptionInfo(Date timestamps, String message, String details) {
		super();
		this.timestamps = timestamps;
		this.message = message;
		this.details = details;
	}

	public RestAPIExceptionInfo(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
