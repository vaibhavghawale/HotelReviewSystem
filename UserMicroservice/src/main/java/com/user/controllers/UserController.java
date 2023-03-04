package com.user.controllers;

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
import org.springframework.web.client.RestTemplate;

import com.user.model.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//<------------------------------------XXXX---------------------------------------->
	
	// create a new user and generate new userId using Post method
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User user1=userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	//<--------------------------------------XXXX--------------------------------------->
	
	// Get single User by UserId 
	// this method is depend on the hotel and rating service if any one is down then we did not get proper output so we use here circuit breaker for managing request 
	
	@GetMapping("/{userId}")
//  @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//  @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String userId){

		User user= userService.getUser(userId);

		return ResponseEntity.ok(user);
	}
	
	
	
	//fallback method for crircuit breaker 
	
	 public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {

       ex.printStackTrace();
       
       //All data is dummy if any service is down and request hiting on server using builder we can set all dummy data.
       
       User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").userid("141234").build();
       return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
   }
	
	
	
	
	//<-------------------------------------XXXX---------------------------------------->
	
	// Get List of All Users.  
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> users= userService.getAllUser();
		
		return ResponseEntity.ok(users);
		
	}
	
	//<--------------------------------------XXXX-------------------------------------->
}
