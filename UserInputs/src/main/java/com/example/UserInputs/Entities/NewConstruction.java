package com.example.UserInputs.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "new_construction_projects")
public class NewConstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
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

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectInputs getProject() {
        return project;
    }

    public void setProject(ProjectInputs project) {
        this.project = project;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isIncludesBasement() {
        return includesBasement;
    }

    public void setIncludesBasement(boolean includesBasement) {
        this.includesBasement = includesBasement;
    }

    public boolean isIncludesGarage() {
        return includesGarage;
    }

    public void setIncludesGarage(boolean includesGarage) {
        this.includesGarage = includesGarage;
    }

    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }
}
