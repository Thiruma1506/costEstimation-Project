package com.example.UserInputs.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "new_construction_projects")
public class NewCunstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectInputs project;

    @Column(nullable = false)
    private int numberOfFloors;

    @Column(nullable = false)
    private int numberOfRooms;

    @Column(nullable = false)
    private boolean includesBasement;

    @Column(nullable = false)
    private boolean includesGarage;

    @Column
    private String specialRequirements; // e.g., "Solar Panels", "Rainwater Harvesting"

    // Getters and setters
    // Constructors
}
