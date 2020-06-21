package com.goldenrealestate.app.repository.dto;

import com.goldenrealestate.app.model.ProgressBar;

public class ProgressBarDTO {
    private String employeeName;
    private String defectName;
    private String buildingName;
    private String status;

    public long getProgressbarid() {
        return progressbarid;
    }

    public void setProgressbarid(long progressbarid) {
        this.progressbarid = progressbarid;
    }

    private long progressbarid;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProgressBarDTO(ProgressBar progressBar) {

        employeeName = progressBar.getEmployee().getEmployeeName();
        defectName   = progressBar.getDefect().getDefectname();
        buildingName =  progressBar.getBuilding().getBuildingname();
        status   =  progressBar.getStatus().getStatustype();
        progressbarid =progressBar.getProgressbarid();
    }
}
