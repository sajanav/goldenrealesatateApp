package com.goldenrealestate.app.repository;

import com.goldenrealestate.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
