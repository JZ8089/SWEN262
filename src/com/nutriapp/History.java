package com.nutriapp;
import java.util.ArrayList;
import java.util.Date;

public class History {
    private double weight;
    private int calorieCount;
    private ArrayList<Meal> meals;
    private ArrayList<Workout> workouts;
    private Date date;

    public History(Date date) {
        this.date = date;
        this.weight = 0;
        this.calorieCount = 0;
        this.meals = new ArrayList<>();
        this.workouts = new ArrayList<>();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    public int getCalorieCount() {
        return this.calorieCount;
    }

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public ArrayList<Meal> getMeals() {
        return this.meals;
    }

    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }

    public ArrayList<Workout> getWorkouts() {
        return this.workouts;
    }

    public Date getDate() {
        return this.date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: " + this.date + "\n");
        sb.append("Weight: " + this.weight + "\n");
        sb.append("Calorie Count: " + this.calorieCount + "\n\n");

        sb.append("Meals:\n");
        for (Meal meal : this.meals) {
            sb.append(meal.toString() + "\n");
        }

        sb.append("Workouts:\n");
        for (Workout workout : this.workouts) {
            sb.append(workout.toString() + "\n");
        }

        return sb.toString();
    }
}