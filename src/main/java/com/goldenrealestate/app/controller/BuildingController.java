package com.goldenrealestate.app.controller;

import com.goldenrealestate.app.model.Building;
import com.goldenrealestate.app.model.Employee;
import com.goldenrealestate.app.repository.BuildingRepository;
import com.goldenrealestate.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BuildingController {
    @Autowired
    BuildingRepository buildingRepository;


    @GetMapping("/buildings")
    public ResponseEntity<List<Building>> getAllBuildings(@RequestParam(required = false) String title) {
        try {
            List<Building> buildings = new ArrayList<Building>();

            if (title == null)
                buildingRepository.findAll().forEach(buildings::add);

            if (buildings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(buildings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
