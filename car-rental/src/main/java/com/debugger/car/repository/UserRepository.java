package com.debugger.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.debugger.car.access.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
