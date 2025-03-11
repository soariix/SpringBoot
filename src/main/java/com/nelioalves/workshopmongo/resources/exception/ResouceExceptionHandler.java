package com.nelioalves.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.workshopmongo.services.exception.ObjectNoFoundEception;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResouceExceptionHandler {

	@ExceptionHandler(ObjectNoFoundEception.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNoFoundEception e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		return ResponseEntity.status(status).body(err);
	}
}