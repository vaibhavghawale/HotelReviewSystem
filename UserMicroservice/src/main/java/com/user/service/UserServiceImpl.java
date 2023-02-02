package com.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.exceptions.UserNotFoundException;
import com.user.model.User;
import com.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository; //we need repository for storing data in a database
	
	
	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserid(randomUserId);
		return userRepository.save(user);
	}

	
	
	@Override
	public List<User> getAllUser() {
	
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with given ID try again :"+userId));
	}


}
