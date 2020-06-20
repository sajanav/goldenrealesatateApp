package com.goldenrealestate.app.repository;

import com.goldenrealestate.app.model.ProgressBar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressBarRepository extends JpaRepository<ProgressBar, Long> {
}