package com.ecom.exception;

public class Http404Exception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Http404Exception(String message) {
		super(message);
	}

}
