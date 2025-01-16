package com.example.materialsLabourEstimation.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String resourceType; // e.g., "Cement", "Steel", "Wood", etc.

    @Column(nullable = false)
    private int quantity; // Quantity in units (e.g., bags, tons, cubic meters)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Quality quality; // Quality: Base Package, Medium, Premium

    @Column(nullable = false)
    private double costPerUnit; // Cost per unit based on the quality

    @Column(nullable = false)
    private String projectType; // New Construction, Renovation, Interior Works

    @Column(nullable = false)
    private Long projectId; // Reference to the UserInput project

    // Enum for Quality
    public enum Quality {
        BASE_PACKAGE,
        MEDIUM,
        PREMIUM
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    // Method to calculate total cost for this material
    public double calculateTotalCost() {
        return this.quantity * this.costPerUnit;
    }
}
