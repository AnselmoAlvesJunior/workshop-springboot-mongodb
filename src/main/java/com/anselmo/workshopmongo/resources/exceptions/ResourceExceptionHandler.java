package com.anselmo.workshopmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anselmo.workshopmongo.services.exception.ObjectNotFoudException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoudException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoudException e,HttpServletRequest request){
		
		HttpStatus status= HttpStatus.NOT_FOUND;
		StandardError err=new StandardError(System.currentTimeMillis(), status.value(), "Not Found!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err); 
		
	}
}
