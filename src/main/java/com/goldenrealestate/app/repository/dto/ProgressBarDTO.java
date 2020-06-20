package com.goldenrealestate.app.repository.dto;

import com.goldenrealestate.app.model.Defect;
import com.goldenrealestate.app.model.ProgressBar;

public class ProgressBarDTO {
    private EmployeeDTO employeeDTO;
    private DefectDTO defectDTO;
    private BuildingDTO buildingDTO;
    private StatusDTO statusDTO;

    public ProgressBarDTO(ProgressBar progressBar) {

        employeeDTO = new EmployeeDTO(progressBar.getEmployee());
        defectDTO   = new DefectDTO(progressBar.getDefect());
        buildingDTO = new BuildingDTO(progressBar.getBuilding());
        statusDTO   = new StatusDTO(progressBar.getStatus());
    }


    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public DefectDTO getDefectDTO() {
        return defectDTO;
    }

    public void setDefectDTO(DefectDTO defectDTO) {
        this.defectDTO = defectDTO;
    }

    public BuildingDTO getBuildingDTO() {
        return buildingDTO;
    }

    public void setBuildingDTO(BuildingDTO buildingDTO) {
        this.buildingDTO = buildingDTO;
    }

    public StatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }

}
