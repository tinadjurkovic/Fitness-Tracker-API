package com.fitnesstracker;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class FitnessTracker {

    @Id
    @SequenceGenerator(
            name = "fitnesstracker_id_sequence",
            sequenceName = "fitnesstracker_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fitnesstracker_id_sequence"
    )
    private int id;
    String workoutType;
    double duration;
    String intensity;
    String title;
    LocalDate date;
    double weight;
    double height;
    String food;
    int calories;

    public FitnessTracker(int id, String workoutType, double duration, String intensity, String title, LocalDate date, double weight, double height, String food, int calories) {
        this.id = id;
        this.workoutType = workoutType;
        this.duration = duration;
        this.intensity = intensity;
        this.title = title;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.food = food;
        this.calories = calories;
    }
    public FitnessTracker() {}

    public int getId() {
        return id;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public double getDuration() {
        return duration;
    }

    public String getIntensity() {
        return intensity;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getFood() {
        return food;
    }

    public int getCalories() {
        return calories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


}