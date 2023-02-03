package com.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exceptions.HotelNotFoundException;
import com.hotel.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	  @Autowired
	  private HotelRepository hotelRepository;

	  	@Override
		public Hotel saveHotel(Hotel hotel) {
		String randomhotelId = UUID.randomUUID().toString();
		System.out.println(randomhotelId);
		 hotel.setHotelid(randomhotelId);
		   return hotelRepository.save(hotel);
		}
	  	
	  	
		@Override
		public List<Hotel> getAllHotels() {
			 return hotelRepository.findAll();
	    }
	
		@Override
		public Hotel getHotelByIdHotel(String id) {
			
			return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("hotel with given id not found !!"));
		}


}
