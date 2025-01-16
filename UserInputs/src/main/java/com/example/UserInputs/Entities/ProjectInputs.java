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

}
