package com.fitnesstracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FitnessTrackerRepository extends JpaRepository<FitnessTracker, Integer> {
    List<FitnessTracker> findByWorkoutType(String workoutType);
    List<FitnessTracker> findByDate(LocalDate date);
    List<FitnessTracker> findByWorkoutTypeAndDate(String workoutType, LocalDate date);
}
