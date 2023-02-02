package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel hotel2= hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
	List<Hotel> hotels= hotelService.getAllHotels();
	return ResponseEntity.ok(hotels);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
		  return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelByIdHotel(hotelId));
	}
	
	
}
