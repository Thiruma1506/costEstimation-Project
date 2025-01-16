package com.example.UserInputs.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "projects")
public class ProjectInputs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projectType; // e.g., "New Construction", "Renovation", "Interior Design"

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private double areaSize; // in square feet/meters

    @Column(nullable = false)
    private String location; // City or region

    @Column(nullable = false)
    private double budget; // Estimated budget

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    // Getters and setters
    // Constructors


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(double areaSize) {
        this.areaSize = areaSize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
