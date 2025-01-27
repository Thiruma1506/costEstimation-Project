//package com.example.apiGateway.Controller;
//
//import com.example.apiGateway.Entity.JwtResponse;
//import com.example.apiGateway.Entity.LoginRequest;
//import com.example.apiGateway.Entity.User;
//import com.example.apiGateway.Filter.JwtUtil;
//import com.example.apiGateway.UserRepository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        if (userRepository.findByUsername(user.getUsername()) != null) {
//            return ResponseEntity.badRequest().body("Username already exists");
//        }
//
//        // Hash password and set default role if not provided
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        if (user.getRole() == null) {
//            user.setRole("ROLE_USER"); // Default role
//        }
//        userRepository.save(user);
//        return ResponseEntity.ok("User registered successfully with role: " + user.getRole());
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
//        User user = userRepository.findByUsername(loginRequest.getUsername());
//        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            return ResponseEntity.status(401).body("Invalid credentials");
//        }
//
//        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//}
