package com.hotel.exceptions;

public class HotelNotFoundException extends RuntimeException {

	public HotelNotFoundException() {
		super("Oops...! Hotel Not found !!!");
	}
	public HotelNotFoundException(String message) {
		super(message);
	}
	
}
