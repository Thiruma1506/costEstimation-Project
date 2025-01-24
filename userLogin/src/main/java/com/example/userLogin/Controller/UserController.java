package com.example.userLogin.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userLogin.Entity.User;
import com.example.userLogin.Service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public User adduser(@RequestBody User user) {
		return service.adduser(user);
	}
	
	@PostMapping("/login")
	public String verify(@RequestBody User user) {
		return service.verify(user);
	}
}