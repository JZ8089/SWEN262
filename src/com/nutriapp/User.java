package com.nutriapp;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String name;
    private int height;
    private double weight;
    private LocalDate birthdate;
    private Goal goal;
    private double dailyCalorieIntake;

    public User(String name, int height, double weight, LocalDate birthdate, Goal goal) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
        this.goal = goal;
        this.goal.update(this);
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Goal getGoal() {
        return goal;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGoal(Goal goal) {
        if (goal != null) {
            this.goal = goal;
            goal.update(this);
        } else {
            throw new IllegalArgumentException("Goal cannot be null.");
        }
    }

    public void setDailyCalorieIntake(double dailyCalorieIntake) {
        this.dailyCalorieIntake = dailyCalorieIntake;
    }
    
    
    
    public double getBMR() {
        double bmr = 0;
        if (goal instanceof LoseWeight) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        } else if (goal instanceof GainWeight) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        } else if (goal instanceof MaintainWeight) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        }
        return bmr;
    }

    public double getDailyCalorieIntake() {
        double bmr = getBMR();
        if (goal instanceof LoseWeight) {
            dailyCalorieIntake = bmr * 0.8;
        } else if (goal instanceof GainWeight) {
            dailyCalorieIntake = bmr * 1.2;
        } else if (goal instanceof MaintainWeight) {
            dailyCalorieIntake = bmr;
        }
        return dailyCalorieIntake;
    }

    public String toString() {
        return "Name: " + name + "\n" +
                "Height: " + height + " cm\n" +
                "Weight: " + weight + " kg\n" +
                "Birthdate: " + birthdate + "\n" +
                "Goal: " + goal + "\n";
    }
}