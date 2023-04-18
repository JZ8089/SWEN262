package com.nutriapp;

/*
 * This interface is responsible for calculating the calories burned during a workout.
 */
public interface WorkoutStrategy {
    int calculateCaloriesBurned(int duration, int intensity);
}
