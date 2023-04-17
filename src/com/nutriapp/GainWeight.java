package com.nutriapp;

public class GainWeight implements Goal {
    public void update(User user) {
        double dailyCalorieIntake = user.getBMR() * 1.2;
        user.setDailyCalorieIntake(dailyCalorieIntake);
        user.setGoal(this);
    }

    public String toString() {
        return "Gain Weight";
    }
}
