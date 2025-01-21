package com.ConstructionCalculator.User.com.ConstructionCalculator.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ConstructionCalculator.User.com.ConstructionCalculator.User.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}

