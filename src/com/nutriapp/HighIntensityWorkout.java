package com.nutriapp;

/*
 * This interface is responsible for calculating the calories burned during a workout.
 */
public class HighIntensityWorkout implements WorkoutStrategy {
    public int calculateCaloriesBurned(int duration, int intensity) {
        return 10 * duration;
    }
}
