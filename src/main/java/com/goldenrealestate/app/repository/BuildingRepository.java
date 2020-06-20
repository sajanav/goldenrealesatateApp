package com.goldenrealestate.app.repository;

import com.goldenrealestate.app.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
