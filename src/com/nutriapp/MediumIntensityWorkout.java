package com.nutriapp;

public class MediumIntensityWorkout implements WorkoutStrategy {
    public int calculateCaloriesBurned(int duration, int intensity) {
        return 7 * (duration / 2);
    }
}
