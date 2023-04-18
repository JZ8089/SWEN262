package com.nutriapp;

public class LowIntensityWorkout implements WorkoutStrategy {
    public int calculateCaloriesBurned(int duration, int intensity) {
        return 5 * duration;
    }
}

