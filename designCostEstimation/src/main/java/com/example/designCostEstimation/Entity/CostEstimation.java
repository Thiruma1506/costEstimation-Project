package com.example.designCostEstimation.Entity;

import jakarta.persistence.*;

// Entity Class for CostEstimation
@Entity
public class CostEstimation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long interiorDesignId; 
    // ID reference to the InteriorDesign entity in a separate microservice

    @Column(nullable = false)
    private double estimatedCost;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInteriorDesignId() {
        return interiorDesignId;
    }

    public void setInteriorDesignId(Long interiorDesignId) {
        this.interiorDesignId = interiorDesignId;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}
