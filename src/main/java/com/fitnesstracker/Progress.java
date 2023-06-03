package com.fitnesstracker;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;

    double weight;
    double height;
    LocalDate date;

    double weightGoal;
    double currentGoal;
    public Progress() {}

    public Progress(int id, double weight, double height, LocalDate date, double weightGoal, double currentGoal) {
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.date = date;
        this.weightGoal = weightGoal;
        this.currentGoal = currentGoal;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public void setCurrentGoal(double currentGoal) {
        this.currentGoal = currentGoal;
    }
}
