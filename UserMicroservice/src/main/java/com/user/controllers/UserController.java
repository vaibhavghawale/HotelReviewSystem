package com.user.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(User user) {
		
		User user2=userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@RequestParam String userId){
		
		User user= userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> users= userService.getAllUser();
		
		return ResponseEntity.ok(users);
		
	}
	
	
}
