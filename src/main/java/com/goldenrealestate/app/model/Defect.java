package com.goldenrealestate.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "defect")
public class Defect implements Serializable {
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

    public String getDefectdesc() {
        return defectdesc;
    }

    public void setDefectdesc(String defectdesc) {
        this.defectdesc = defectdesc;
    }
}
