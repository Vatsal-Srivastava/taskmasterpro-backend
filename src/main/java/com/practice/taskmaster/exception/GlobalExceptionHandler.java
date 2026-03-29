package com.practice.taskmaster.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExitsException.class)
	public ResponseEntity<Map<String, String>> userAlreadyExitsExceptionHandler(UserAlreadyExitsException ex) {
		Map<String, String> errorResponse = new HashMap<>();
		//Try using errorcode file and errorresponse
		errorResponse.put("ERROR","USER_ALREADY_EXITS");
		errorResponse.put("message",ex.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
	}
}
