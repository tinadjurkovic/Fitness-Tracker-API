package com.fitnesstracker;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fitnesstracker")
public class FitnessTrackerController {

    private final FitnessTrackerService fitnessTrackerService;

    public FitnessTrackerController(FitnessTrackerService fitnessTrackerService) {
        this.fitnessTrackerService = fitnessTrackerService;
    }

    @GetMapping
    public List<FitnessTracker> getWorkoutHistory(
            @RequestParam(value = "workoutType", required = false) String workoutType,
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return fitnessTrackerService.filterWorkouts(workoutType, date);
    }

    @PostMapping
    public void addWorkout(@RequestBody Main.NewWorkoutRequest workoutRequest) {
        fitnessTrackerService.addWorkout(workoutRequest);
    }

    @PutMapping("/workouts/{id}")
    public void updateWorkout(
            @PathVariable("id") int id,
            @RequestBody FitnessTracker updatedWorkout
    ) {
        fitnessTrackerService.updateWorkout(id, updatedWorkout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable("id") Integer id) {

        fitnessTrackerService.deleteWorkout(id);
    }


}
