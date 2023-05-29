package com.fitnesstracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@SpringBootApplication
@RestController
@RequestMapping("/fitness")

public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }
}
record NewWorkoutRequest(
        String workoutType,
        double duration,
        String intensity,
        String title,
        LocalDate date,
        double weight,
        double height,
        String food,
        int calories
){}