package com.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.user.exceptions.UserNotFoundException;
import com.user.model.Hotel;
import com.user.model.Rating;
import com.user.model.User;
import com.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private RestTemplate restTemplate; //This rest Template need for Bean the other micro services 
	
	@Autowired
	private UserRepository userRepository; //we need repository for storing data in a database

	
	//<------------------------------------XXXX---------------------------------------->
	
		// create a new user 
	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserid(randomUserId);
		return userRepository.save(user);
	}

	//<--------------------------------------XXXX--------------------------------------->
	
		// Get All Users
	
	@Override
	public List<User> getAllUser() {
	
		List<User> userList =  userRepository.findAll();
		
		for(User users:userList) {
//			ArrayList<Rating> ratingUserList= restTemplate.getForObject("http://localhost:8083/ratings/users/"+ users.getUserid(),ArrayList.class);
//			users.setRatings(ratingUserList);
			
			
			Rating []  ratingUserList= restTemplate.getForObject("http://RATING-SERVICES/ratings/users/"+users.getUserid(),Rating[].class);
			
			
			// convert ti array in to array list 
			List<Rating> listOfRatings =Arrays.stream(ratingUserList).toList();
			
			//Map every rating and set a hotel to each
			List<Rating> ratingList= listOfRatings.stream().map(rating -> {
				ResponseEntity<Hotel> forEntity =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
				Hotel hotel =forEntity.getBody();
							
				rating.setHotel(hotel);
				
				return rating;
				
			}).collect(Collectors.toList());
		
			users.setRatings(ratingList);
			
		}
		return userList;
	}

	//<-------------------------------------XXXX---------------------------------------->
	
	// Get single User By UserId. 
	
	@Override
	public User getUser(String userId) {
		
		User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with given ID try again :"+userId));
		
		//Fetch the Rating for above user from Rating Micro-service for that we going to RestTemplate or fin client
		
		//note: check Rating Service have that API or not for communication for e.g localhost:8083//ratings/userid  
		
		//http://localhost:8083/ratings/users/8b9ce2a8-46e6-4c7c-ac95-738b2aa2b6a1 
		//you can convert dinamic url using service name it benifite is after deploying a app we dont have to care about port and all.
		// check confugation file @loadbalance need to implement name insted of port number.
		
		Rating []  ratingUserList= restTemplate.getForObject("http://RATING-SERVICES/ratings/users/"+user.getUserid(),Rating[].class);
		
		
		// convert ti array in to array list 
		List<Rating> listOfRatings =Arrays.stream(ratingUserList).toList();
		
		//Map every rating and set a hotel to each
		List<Rating> ratingList= listOfRatings.stream().map(rating -> {
			ResponseEntity<Hotel> forEntity =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel =forEntity.getBody();
						
			rating.setHotel(hotel);
			
			return rating;
			
		}).collect(Collectors.toList());
	
		user.setRatings(ratingList);
		
		return user;
	}

	//<-------------------------------------XXXX---------------------------------------->
	

}
