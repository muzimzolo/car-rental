package com.debugger.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debugger.car.security.auth.User;


public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    
}