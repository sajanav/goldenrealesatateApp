package com.goldenrealestate.app.model;

import javax.persistence.*;

@Entity
@Table(name = "defect")
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long defectid;

    @Column(name = "defectname")
    private String defectname;

    @Column(name = "defectdesc")
    private String defectdesc;

    public String getDefectname() {
        return defectname;
    }

    public void setDefectname(String defectname) {
        this.defectname = defectname;
    }
}
