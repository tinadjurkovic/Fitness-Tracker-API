package com.fitnesstracker;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class FitnessTrackerService {
    private final FitnessTrackerRepository fitnessTrackerRepository;

    public FitnessTrackerService(FitnessTrackerRepository fitnessTrackerRepository) {
        this.fitnessTrackerRepository = fitnessTrackerRepository;
    }

    public List<FitnessTracker> filterWorkouts(String workoutType, LocalDate date) {
        if (workoutType != null && date != null) {
            return fitnessTrackerRepository.findByWorkoutTypeAndDate(workoutType, date);
        } else if (workoutType != null) {
            return fitnessTrackerRepository.findByWorkoutType(workoutType);
        } else if (date != null) {
            return fitnessTrackerRepository.findByDate(date);
        } else {
            return fitnessTrackerRepository.findAll();
        }
    }

    @GetMapping("/workouts")
    public List<FitnessTracker> getWorkoutHistory(
            @RequestParam(value = "workoutType", required = false) String workoutType,
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return filterWorkouts(workoutType, date);
    }

    @PutMapping("/workouts/{id}")
    public void updateWorkout(
            @PathVariable("id") int id,
            @RequestBody FitnessTracker updatedWorkout
    ) {
        FitnessTracker workout = fitnessTrackerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid workout ID: " + id));

        workout.setWorkoutType(updatedWorkout.getWorkoutType());
        workout.setDuration(updatedWorkout.getDuration());
        workout.setIntensity(updatedWorkout.getIntensity());
        workout.setTitle(updatedWorkout.getTitle());
        workout.setDate(updatedWorkout.getDate());
        workout.setWeight(updatedWorkout.getWeight());
        workout.setHeight(updatedWorkout.getHeight());
        workout.setFood(updatedWorkout.getFood());
        workout.setCalories(updatedWorkout.getCalories());

        fitnessTrackerRepository.save(workout);
    }
}
