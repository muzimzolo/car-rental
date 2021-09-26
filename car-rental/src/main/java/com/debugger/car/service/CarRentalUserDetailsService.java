package com.debugger.car.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.debugger.car.repository.AuthGroupRepository;
import com.debugger.car.repository.UserRepository;
import com.debugger.car.security.auth.AuthGroup;
import com.debugger.car.security.auth.CarRentalUserPrincipal;
import com.debugger.car.security.auth.User;


@Component
public class CarRentalUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public CarRentalUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository){
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if(null==user){
            throw new UsernameNotFoundException("cannot find username: " + username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
       return new CarRentalUserPrincipal(user, authGroups);
    }
}
