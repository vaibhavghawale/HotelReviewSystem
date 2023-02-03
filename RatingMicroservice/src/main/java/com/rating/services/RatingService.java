package com.rating.services;

import java.util.List;

import com.rating.model.Rating;

public interface RatingService {
	
	//Create Rating or Save rating
	
	Rating createRating(Rating rating);
	
	//Get All Rating
	
	List<Rating> getAllRatings();
	
	//Get Rating by USer Id
	
	List<Rating> getRatingByUserId(String userId);
	
	//Get Rating by Hotel Id
	
	List<Rating> getRatingByHotelId(String hotelId);
}
