package com.fitnesstracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    private final ProgressRepository progressRepository;

    @Autowired
    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public Progress getProgressById(int progressId) {
        return progressRepository.findById(progressId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid progress ID: " + progressId));
    }

    public void addProgress(Main.NewProgressRequest progressRequest) {
        Progress progress = new Progress();
        progress.setWeight(progressRequest.weight());
        progress.setHeight(progressRequest.height());
        progress.setDate(progressRequest.date());
        progress.setWeightGoal(progressRequest.weightGoal());
        progress.setCurrentGoal(progressRequest.currentGoal());

        progressRepository.save(progress);
    }

    public void updateProgress(int progressId, Main.NewProgressRequest updatedProgressRequest) {
        Progress progress = progressRepository.findById(progressId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid progress ID: " + progressId));

        progress.setWeight(updatedProgressRequest.weight());
        progress.setHeight(updatedProgressRequest.height());
        progress.setDate(updatedProgressRequest.date());
        progress.setWeightGoal(updatedProgressRequest.weightGoal());
        progress.setCurrentGoal(updatedProgressRequest.currentGoal());

        progressRepository.save(progress);
    }

    public void deleteProgress(int progressId) {

        progressRepository.deleteById(progressId);
    }
}