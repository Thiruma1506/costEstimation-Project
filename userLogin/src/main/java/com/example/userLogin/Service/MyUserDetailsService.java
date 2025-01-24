package com.example.userLogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.userLogin.Repository.userRepo;
import com.example.userLogin.Entity.User;
import com.example.userLogin.Entity.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private userRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Not found username");
		}
		return new UserPrincipal(user); 
	}
}