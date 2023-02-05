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
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User user= userService.getUser(userId);
		
		
		return ResponseEntity.ok(user);
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
