package com.goldenrealestate.app.repository.dto;

import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;


public class ProgressBarDetailsTO {



    private List <ProgressBarDTO> progressBarDetails;

    public List<ProgressBarDTO> getProgressBarDetails() {
        return progressBarDetails;
    }

    public void setProgressBarDetails(List<ProgressBarDTO> progressBarDetails) {
        this.progressBarDetails = progressBarDetails;
    }
}
