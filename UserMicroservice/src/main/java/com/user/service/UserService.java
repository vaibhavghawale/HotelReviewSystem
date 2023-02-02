package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {
	
	//create new user using saveUser service.
	public User saveUser(User user);
	
	//get all the User
	
	public List<User> getAllUser();
	
	//get single user using uid
	
	public User getUser(String userId);
	

}
