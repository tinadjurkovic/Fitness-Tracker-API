package com.fitnesstracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService progressService;

    @Autowired
    public ProgressController(ProgressService progressService) {

        this.progressService = progressService;
    }

    @GetMapping
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }

    @GetMapping("/{id}")
    public Progress getProgressById(@PathVariable("id") int id) {
        return progressService.getProgressById(id);
    }

    @PostMapping
    public void addProgress(@RequestBody Main.NewProgressRequest progress) {
        progressService.addProgress(progress);
    }

    @PutMapping("/{id}")
    public void updateProgress(@PathVariable("id") int id, @RequestBody Main.NewProgressRequest updatedProgress) {
        progressService.updateProgress(id, updatedProgress);
    }

    @DeleteMapping("/{id}")
    public void deleteProgress(@PathVariable("id") int id) {
        progressService.deleteProgress(id);
    }
}