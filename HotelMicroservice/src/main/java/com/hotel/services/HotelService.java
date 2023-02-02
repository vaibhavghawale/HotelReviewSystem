package com.hotel.services;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelService {

	public Hotel saveHotel(Hotel hotal);
	
	public List<Hotel> getAllHotels();

	public Hotel getHotelByIdHotel(String id);
}
