package com.goldenrealestate.app.repository;

import com.goldenrealestate.app.model.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository extends JpaRepository<Defect, Long> {
}
