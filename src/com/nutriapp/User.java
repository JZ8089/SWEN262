package com.nutriapp;
import java.time.LocalDate;
import java.time.Period;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String name;
    private int height;
    private double weight;
    private LocalDate birthdate;
    private Goal goal;

    public User(String name, int height, double weight, LocalDate birthdate, Goal goal) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
        this.goal = goal;
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
        this.goal = goal;
    }

    public double getBMR() {
        double bmr = 0;
        if (goal == Goal.LOSE_WEIGHT) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        } else if (goal == Goal.GAIN_WEIGHT) {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        } else {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * getAge());
        }
        return bmr;
    }

    public double getDailyCalorieIntake() {
        double bmr = getBMR();
        double dailyCalorieIntake = 0;
        if (goal == Goal.LOSE_WEIGHT) {
            dailyCalorieIntake = bmr * 0.8;
        } else if (goal == Goal.GAIN_WEIGHT) {
            dailyCalorieIntake = bmr * 1.2;
        } else {
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

    public void saveUser() throws IOException {
        // check if a file ../../../data/user.csv exists
        // if it doesnt exist, create it
        String filePath = "../../../data/user.csv";
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }
        // write the user's data to the file
        // name, height, weight, birthdate, goal
        // comma seperate all the data, one user per line
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(String.format(".user {\n\tname: \"%s\";\n\theight: %dcm;\n\tweight: %.2fkg;\n\tbirthdate: \"%s\";\n\tgoal: \"%d\";\n}\n",
                    this.name,
                    this.height,
                    this.weight,
                    this.birthdate,
                    this.goal.getValue()
            ));
        }

    }

    // function to delete a user from the ../../../../data/user.csv file (if it exists)
    public void deleteUser() throws IOException {
        String filePath = "../../../data/user.csv";

        // find the line with the users name and delete it, then shift all the other lines up
        // if the user is not found, do nothing
        

    }


}