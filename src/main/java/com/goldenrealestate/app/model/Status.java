package com.goldenrealestate.app.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status")
public class Status  implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statusid;

    @Column(name = "statustype")
    private String statustype;
    
    public String getStatustype() {
        return statustype;
    }

    public void setStatustype(String statustype) {
        this.statustype = statustype;
    }




}
