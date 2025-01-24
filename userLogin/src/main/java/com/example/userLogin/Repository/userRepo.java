package com.example.userLogin.Repository;

import com.example.userLogin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface userRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
