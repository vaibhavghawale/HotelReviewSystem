package com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	//we can write custome methods here also
}
