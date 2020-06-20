package com.goldenrealestate.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "progressbar")
public class ProgressBar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progressbarid")
    private long progressbarid;


    @ManyToOne
    @JoinColumn(name ="assign_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name ="assign_builiding")
    private Building building;

    @ManyToOne
    @JoinColumn(name ="assign_defect")
    private Defect defect;

    @ManyToOne
    @JoinColumn(name ="assign_status")
    private Status status;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Defect getDefect() {
        return defect;
    }

    public void setDefect(Defect defect) {
        this.defect = defect;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
