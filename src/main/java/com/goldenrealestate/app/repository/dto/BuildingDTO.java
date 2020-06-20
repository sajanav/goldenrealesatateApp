package com.goldenrealestate.app.repository.dto;

import com.goldenrealestate.app.model.Building;

import javax.persistence.Column;

public class BuildingDTO {


    private String buildingname;
    private String location;

    public BuildingDTO(Building building) {
        buildingname=building.getBuildingname();
        location=building.getLocation();
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
