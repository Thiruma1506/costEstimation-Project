//package com.example.apiGateway.Service;
//
//import com.example.apiGateway.Entity.User;
//import com.example.apiGateway.UserRepository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//
//    public User register(User user) {
//        if (userRepository.findByUsername(user.getUsername()) != null) {
//            throw new RuntimeException("Username already exists");
//        }
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        // Set default role if not provided
//        if (user.getRole() == null) {
//            user.setRole("ROLE_USER");
//        }
//        return userRepository.save(user);
//    }
//
//}
