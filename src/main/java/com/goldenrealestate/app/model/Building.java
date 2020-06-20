package com.goldenrealestate.app.model;

import javax.persistence.*;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long buildingid;

    @Column(name = "buildingname")
    private String buildingname;

    @Column(name = "location")
    private String location;

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
