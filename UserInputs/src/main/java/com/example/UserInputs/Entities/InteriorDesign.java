package com.example.UserInputs.Entities;

import jakarta.persistence.*;

public class InteriorDesign {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interiorDesignId;

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

    // Dropdown properties
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesignOption space;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesignOption form;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesignOption line;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesignOption light;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesignOption colour;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesignOption pattern;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesignOption texture;

    // Getters and setters
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

    public DesignOption getSpace() {
        return space;
    }

    public void setSpace(DesignOption space) {
        this.space = space;
    }

    public DesignOption getForm() {
        return form;
    }

    public void setForm(DesignOption form) {
        this.form = form;
    }

    public DesignOption getLine() {
        return line;
    }

    public void setLine(DesignOption line) {
        this.line = line;
    }

    public DesignOption getLight() {
        return light;
    }

    public void setLight(DesignOption light) {
        this.light = light;
    }

    public DesignOption getColour() {
        return colour;
    }

    public void setColour(DesignOption colour) {
        this.colour = colour;
    }

    public DesignOption getPattern() {
        return pattern;
    }

    public void setPattern(DesignOption pattern) {
        this.pattern = pattern;
    }

    public DesignOption getTexture() {
        return texture;
    }

    public void setTexture(DesignOption texture) {
        this.texture = texture;
    }

    public enum DesignOption {
        BASIC,
        PREMIUM,
        LUXURY
    }
}
