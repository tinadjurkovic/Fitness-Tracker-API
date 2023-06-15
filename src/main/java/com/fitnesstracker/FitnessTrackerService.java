package com.fitnesstracker;

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

    @PutMapping ("/workouts/{id}")
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

    public void addWorkout(Main.NewWorkoutRequest newWorkoutRequest) {
        FitnessTracker workout = new FitnessTracker();

        workout.setWorkoutType(newWorkoutRequest.workoutType());
        workout.setDuration(newWorkoutRequest.duration());
        workout.setIntensity(newWorkoutRequest.intensity());
        workout.setTitle(newWorkoutRequest.title());
        workout.setDate(newWorkoutRequest.date());
        workout.setWeight(newWorkoutRequest.weight());
        workout.setHeight(newWorkoutRequest.height());
        workout.setFood(newWorkoutRequest.food());
        workout.setCalories(newWorkoutRequest.calories());

        fitnessTrackerRepository.save(workout);
    }

    public void deleteWorkout(Integer id) {
        FitnessTracker workout = fitnessTrackerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid workout ID: " + id));

        fitnessTrackerRepository.delete(workout);
    }
}
