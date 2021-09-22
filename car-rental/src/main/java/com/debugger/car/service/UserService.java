package com.debugger.car.service;

import com.debugger.car.access.User;

public interface UserService {

	public User findByEmail(String email);
	
}