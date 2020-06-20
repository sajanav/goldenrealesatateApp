package com.goldenrealestate.app.controller;

import com.goldenrealestate.app.model.ProgressBar;
import com.goldenrealestate.app.repository.ProgressBarRepository;
import com.goldenrealestate.app.repository.dto.ProgressBarDTO;
import com.goldenrealestate.app.repository.dto.ProgressBarDetailsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProgressBarController {
    @Autowired
    ProgressBarRepository progressBarRepository;


    @GetMapping("/progressbar")
    public ResponseEntity<ProgressBarDetailsTO> getAllProgressBars(@RequestParam(required = false) String title) {
        try {
            List<ProgressBar> progressBars = new ArrayList<ProgressBar>();

            if (title == null)
                progressBarRepository.findAll().forEach(progressBars::add);

            if (progressBars.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return  new ResponseEntity<>(createProgressBarDTO(progressBars),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ProgressBarDetailsTO createProgressBarDTO(List<ProgressBar> progressBars) {
        ProgressBarDetailsTO detailsTO = new ProgressBarDetailsTO();
        List<ProgressBarDTO> progressBarsDTOs = new ArrayList<ProgressBarDTO>();
        for (ProgressBar progressBar : progressBars) {
           ProgressBarDTO progressBarDTO = new ProgressBarDTO(progressBar);
            progressBarsDTOs.add(progressBarDTO);
        }
        detailsTO.setProgressBarDetails(progressBarsDTOs);
        return detailsTO;
    }
}
