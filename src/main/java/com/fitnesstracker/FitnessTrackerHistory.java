package com.fitnesstracker;

import java.time.LocalDate;

public class FitnessTrackerHistory {

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

    public FitnessTrackerHistory(int id, String workoutType, double duration, String intensity, String title, LocalDate date, double weight, double height, String food, int calories) {
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

    public FitnessTrackerHistory() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}