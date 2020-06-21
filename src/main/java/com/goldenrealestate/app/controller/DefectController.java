package com.goldenrealestate.app.controller;

import com.goldenrealestate.app.model.Defect;
import com.goldenrealestate.app.repository.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DefectController {

    @Autowired
    DefectRepository defectRepository;


    @GetMapping("/defects")
    public ResponseEntity<List<Defect>> getAllDefects(@RequestParam(required = false) String title) {
        try {
            List<Defect> defects = new ArrayList<>();

            if (title == null)
                defects.addAll(defectRepository.findAll());

            if (defects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(defects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
