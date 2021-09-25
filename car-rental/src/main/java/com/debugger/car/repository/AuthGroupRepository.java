package com.debugger.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debugger.car.security.auth.AuthGroup;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}