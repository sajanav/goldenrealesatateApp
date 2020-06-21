package com.goldenrealestate.app.repository.dto;

import com.goldenrealestate.app.model.Defect;

public class DefectDTO {


    private String defectname;
    private String defectdesc;

    public DefectDTO(Defect defect) {
        defectname=defect.getDefectname();
        defectdesc=defect.getDefectdesc();
    }

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
