package com.goldenrealestate.app.repository;

import java.util.List;

import com.goldenrealestate.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByEmployeeNameContaining(String employeename);
}
