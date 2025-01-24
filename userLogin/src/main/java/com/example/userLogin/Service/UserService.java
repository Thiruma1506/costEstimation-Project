package com.example.userLogin.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userLogin.Entity.User;
import com.example.userLogin.Repository.userRepo;

@Service
public class UserService {
	
	@Autowired
	private JWTservice jwtservice;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private userRepo repo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public User adduser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return user;
	}

	public String verify(User user) {
		
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	
		if(authentication.isAuthenticated()) {
			return jwtservice.generateToken(user.getUsername());
		}
		return "fail";
	}
	
	
}