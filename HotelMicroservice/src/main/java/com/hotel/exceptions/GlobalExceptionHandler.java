package com.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 			// this is a centrelise for exception handling when ever exception occur then automatic this exception handler will call and handle the exception
public class GlobalExceptionHandler {

	@ExceptionHandler(HotelNotFoundException.class) //when user exception occur then this method call auto
	public ResponseEntity<ApiResponse> handlerUserNotFoundException(HotelNotFoundException ex){
		
		String message=ex.getMessage();
		
		ApiResponse responce= ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<ApiResponse>(responce,HttpStatus.NOT_FOUND);
		
		
	}
	
	
}
