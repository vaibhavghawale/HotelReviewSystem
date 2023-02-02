package com.user.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
	
		super("Resouce Not found on server!!!");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	
	
}
