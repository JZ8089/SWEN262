package com.nutriapp;

import java.time.LocalDate;

/*
 * This class is responsible for logging a user's weight.
 */
public class WeightLogger implements WeightObserver {
    private User user;

    public WeightLogger(User user) {
        this.user = user;
        this.user.registerWeightObserver(this);
    }

    @Override
    public void updateWeight(double weight) {
        System.out.println(user.getName() + " weighed " + weight + " pounds on " + LocalDate.now());
    }

    public void stopLogging() {
        user.unregisterWeightObserver(this);
    }
}
