package com.ConstructionCalculator.User.com.ConstructionCalculator.User.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ConstructionCalculator.User.com.ConstructionCalculator.User.Model.User;
import com.ConstructionCalculator.User.com.ConstructionCalculator.User.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Method to find user by email for login
    public User loginUser(String email) {
        return userRepository.findByEmail(email);
    }

    // Method to get a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to create a user
    public User createUser(String name, String email, String password, String projectId) throws IllegalArgumentException {
        // Check if the email is already registered
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already registered");
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(password);

        // Create new user
        User user = new User(name, email, hashedPassword, projectId);
        return userRepository.save(user);
    }

    // Method to update user information
    public Optional<User> updateUser(Long id, String name, String email, String password, String projectId) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User updatedUser = user.get();
            if (name != null) updatedUser.setName(name);
            if (email != null) updatedUser.setEmail(email);
            if (password != null) updatedUser.setPassword(passwordEncoder.encode(password));
            if (projectId != null) updatedUser.setProjectId(projectId);
            return Optional.of(userRepository.save(updatedUser));
        }
        return Optional.empty();
    }
}
