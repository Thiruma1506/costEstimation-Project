package com.example.User_Input.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "area_requests")
public class Inputs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;  // Optimistic Locking field

    private String userEmail;
    private String userName;
    private String city;
    private String state;
    private Double builtupArea;
    private String propertyName;
    private String propertyType;
    private Integer flatsPerFloor;
    private Integer cabinsNeeded;
    private Boolean landClearanceNeeded;
    private Boolean landClearance;
    private Integer floorsNeeded;
    private Boolean isEstimated = false;
    private Boolean isStartBuild = false;
    private String constructorList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getBuiltupArea() {
        return builtupArea;
    }

    public void setBuiltupArea(Double builtupArea) {
        this.builtupArea = builtupArea;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getFlatsPerFloor() {
        return flatsPerFloor;
    }

    public void setFlatsPerFloor(Integer flatsPerFloor) {
        this.flatsPerFloor = flatsPerFloor;
    }

    public Integer getCabinsNeeded() {
        return cabinsNeeded;
    }

    public void setCabinsNeeded(Integer cabinsNeeded) {
        this.cabinsNeeded = cabinsNeeded;
    }

    public Boolean getLandClearanceNeeded() {
        return landClearanceNeeded;
    }

    public void setLandClearanceNeeded(Boolean landClearanceNeeded) {
        this.landClearanceNeeded = landClearanceNeeded;
    }

    public Boolean getLandClearance() {
        return landClearance;
    }

    public void setLandClearance(Boolean landClearance) {
        this.landClearance = landClearance;
    }

    public Integer getFloorsNeeded() {
        return floorsNeeded;
    }

    public void setFloorsNeeded(Integer floorsNeeded) {
        this.floorsNeeded = floorsNeeded;
    }

    public Boolean getEstimated() {
        return isEstimated;
    }

    public void setEstimated(Boolean estimated) {
        isEstimated = estimated;
    }

    public Boolean getStartBuild() {
        return isStartBuild;
    }

    public boolean setStartBuild(Boolean startBuild) {
        isStartBuild = startBuild;
        return isStartBuild;
    }

    public String getConstructorList() {
        return constructorList;
    }

    public void setConstructorList(String constructorList) {
        this.constructorList = constructorList;
    }

    public Inputs(Long id, String userEmail, String userName, String city, String state, Double builtupArea, String propertyName, String propertyType, Integer flatsPerFloor, Integer cabinsNeeded, Boolean landClearanceNeeded, Boolean landClearance, Integer floorsNeeded, Boolean isEstimated, Boolean isStartBuild, String constructorList) {
        this.id = id;
        this.userEmail = userEmail;
        this.userName = userName;
        this.city = city;
        this.state = state;
        this.builtupArea = builtupArea;
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.flatsPerFloor = flatsPerFloor;
        this.cabinsNeeded = cabinsNeeded;
        this.landClearanceNeeded = landClearanceNeeded;
        this.landClearance = landClearance;
        this.floorsNeeded = floorsNeeded;
        this.isEstimated = isEstimated;
        this.isStartBuild = isStartBuild;
        this.constructorList = constructorList;
    }

    public Inputs() {
    }
}
