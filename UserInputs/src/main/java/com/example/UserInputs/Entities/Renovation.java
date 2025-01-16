package com.example.UserInputs.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "renovation_projects")
public class Renovation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "project_id", nullable = false)
        private ProjectInputs project;

        @Column(nullable = false)
        private String renovationType; // e.g., "Kitchen", "Bathroom", "Living Room"

        @Column(nullable = false)
        private boolean requiresStructuralChanges;

        @Column
        private String additionalNotes;

        // Getters and setters
        // Constructors


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

    public String getRenovationType() {
        return renovationType;
    }

    public void setRenovationType(String renovationType) {
        this.renovationType = renovationType;
    }

    public boolean isRequiresStructuralChanges() {
        return requiresStructuralChanges;
    }

    public void setRequiresStructuralChanges(boolean requiresStructuralChanges) {
        this.requiresStructuralChanges = requiresStructuralChanges;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
