package com.ecom.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CentralExceptionalHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<RestAPIExceptionInfo> handleAllExceptions(Exception ex, WebRequest request) {
		RestAPIExceptionInfo exceptionResponse = new RestAPIExceptionInfo(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Http400Exception.class)
	public final ResponseEntity<RestAPIExceptionInfo> handleUserNotoundExceptions(Exception ex, WebRequest request) {
		RestAPIExceptionInfo exceptionResponse = new RestAPIExceptionInfo(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}

}
