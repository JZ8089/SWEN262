package com.nutriapp;

public class HighIntensityWorkout implements WorkoutStrategy {
    public int calculateCaloriesBurned(int duration, int intensity) {
        return 10 * duration;
    }
}
