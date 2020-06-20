package com.goldenrealestate.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.goldenrealestate.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.goldenrealestate.app.repository.EmployeeRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>>getAllEmployees(@RequestParam(required = false) String title) {
		try {
				List<Employee> employees = new ArrayList<Employee>();

			if (title == null)
				employeeRepository.findAll().forEach(employees::add);
			else
				employeeRepository.findByEmployeeNameContaining(title).forEach(employees::add);

			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Employee> getTutorialById(@PathVariable("id") long id) {
		Optional<Employee> tutorialData = employeeRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tutorials")
	public ResponseEntity<Employee> createTutorial(@RequestBody Employee emp) {
		try {
			/*Employee _employee = tutorialRepository
					.save(new Employee(emp.getEmployeeName(), false));*/
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Employee> updateTutorial(@PathVariable("id") long id, @RequestBody Employee tutorial) {
		Optional<Employee> tutorialData = employeeRepository.findById(id);

		if (tutorialData.isPresent()) {
			Employee _tutorial = tutorialData.get();
		/*	_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());*/
			return new ResponseEntity<>(employeeRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			employeeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Employee>> findByPublished() {
		try {
		//	List<Employee> _employee = tutorialRepository.findByPublished(true);

			/*if (_employee.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}*/
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
