package com.example.UserInputs.Repository;

import com.example.UserInputs.Entities.InteriorDesign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteriorDesignRepo extends JpaRepository<InteriorDesign,Long> {
}

// package com.example.UserInputs.Repositories;

// import com.example.UserInputs.Entities.InteriorDesign;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface InteriorDesignRepository extends JpaRepository<InteriorDesign, Long> {
// }