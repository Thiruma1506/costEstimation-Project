package com.example.designCostEstimation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.designCostEstimation.Entity.CostEstimation;

@Repository
public interface CostEstimationRepository extends JpaRepository<CostEstimation, Long> {
}