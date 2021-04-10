package com.ecom.exception;

public class Http400Exception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Http400Exception(String message) {
		super(message);
	}

	public Http400Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public Http400Exception(Throwable cause) {
		super(cause);

	}

	public Http400Exception(String message, Throwable cause) {
		super(message, cause);

	}

}
