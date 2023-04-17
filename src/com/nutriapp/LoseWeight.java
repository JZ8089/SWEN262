package com.nutriapp;

public class LoseWeight implements Goal {
    public void update(User user) {
        double dailyCalorieIntake = user.getBMR() * 0.8;
        user.setDailyCalorieIntake(dailyCalorieIntake);
        user.setGoal(this);
    }

    public String toString() {
        return "Lose Weight";
    }
}
