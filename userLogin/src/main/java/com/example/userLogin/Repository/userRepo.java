package com.example.userLogin.Repository;

import com.example.userLogin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
