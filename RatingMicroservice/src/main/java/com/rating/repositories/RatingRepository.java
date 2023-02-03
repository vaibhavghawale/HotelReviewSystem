package com.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rating.model.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {
	
	//Here we are using mongo db so we have to extend mondodb repository to genrate queries
	
	//Customer method for user and hotel
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
	
}