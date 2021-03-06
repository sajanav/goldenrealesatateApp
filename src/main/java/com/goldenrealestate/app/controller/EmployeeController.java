package com.goldenrealestate.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.goldenrealestate.app.model.Employee;
import com.goldenrealestate.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>>getAllEmployees(@RequestParam(required = false) String title) {
		try {
				List<Employee> employees = new ArrayList<>();
			if (title == null)
				employees.addAll(employeeRepository.findAll());
			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
