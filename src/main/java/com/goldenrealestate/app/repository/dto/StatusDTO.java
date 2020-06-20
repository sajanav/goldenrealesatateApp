package com.goldenrealestate.app.repository.dto;

import com.goldenrealestate.app.model.Status;

public class StatusDTO {



    private String statustype;

    public StatusDTO(Status status) {
        statustype = status.getStatustype();
    }

    public String getStatustype() {
        return statustype;
    }

    public void setStatustype(String statustype) {
        this.statustype = statustype;
    }

}
