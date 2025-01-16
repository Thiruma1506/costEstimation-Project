package com.example.UserInputs.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Future;
import java.util.Date;

public class ResponseDTO {
    @NotNull
    @Size(min = 3, max = 50)
    private String projectName;

    @NotNull
    private String projectType;

    @Positive
    private double areaSize;

    @NotNull
    @Size(min = 2, max = 100)
    private String location;

    @Positive
    private double budget;

    @Future
    private Date startDate;

    @Future
    private Date endDate;



    // Add other getters and setters here

    public @NotNull @Size(min = 3, max = 50) String getProjectName() {
        return projectName;
    }

    public void setProjectName(@NotNull @Size(min = 3, max = 50) String projectName) {
        this.projectName = projectName;
    }

    public @NotNull String getProjectType() {
        return projectType;
    }

    public void setProjectType(@NotNull String projectType) {
        this.projectType = projectType;
    }

    @Positive
    public double getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(@Positive double areaSize) {
        this.areaSize = areaSize;
    }

    public @NotNull @Size(min = 2, max = 100) String getLocation() {
        return location;
    }

    public void setLocation(@NotNull @Size(min = 2, max = 100) String location) {
        this.location = location;
    }

    @Positive
    public double getBudget() {
        return budget;
    }

    public void setBudget(@Positive double budget) {
        this.budget = budget;
    }

    public @Future Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@Future Date startDate) {
        this.startDate = startDate;
    }

    public @Future Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@Future Date endDate) {
        this.endDate = endDate;
    }
}