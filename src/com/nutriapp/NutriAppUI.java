package com.nutriapp;
import java.util.Scanner;

public class NutriAppUI {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Welcome to NutriApp!");
        System.out.println("1. Create a new user");
        System.out.println("2. Add a new meal");
        System.out.println("3. Add a new workout");
        System.out.println("4. View user history");
        System.out.println("5. Exit");
    }

    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void displayUserForm() {
        System.out.println("Create a new user");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your height: ");
        int height = scanner.nextInt();
        System.out.print("Enter your weight: ");
        int weight = scanner.nextInt();
        System.out.print("Enter your birthdate (YYYY-MM-DD): ");
        String birthdate = scanner.next();
        // Save the user data to the database
    }

    public void displayMealForm() {
        System.out.println("Add a new meal");
        System.out.print("Enter the name of the meal: ");
        String mealName = scanner.next();
        System.out.print("Enter the ingredients (comma separated): ");
        String ingredients = scanner.next();
        System.out.print("Enter the calories: ");
        int calories = scanner.nextInt();
        // Save the meal data to the database
    }

    public void displayWorkoutForm() {
        System.out.println("Add a new workout");
        System.out.print("Enter the duration (in minutes): ");
        int duration = scanner.nextInt();
        System.out.print("Enter the intensity: ");
        String intensity = scanner.next();
        System.out.print("Enter the date (YYYY-MM-DD): ");
        String date = scanner.next();
        // Save the workout data to the database
    }

    public void displayUserHistory() {
        System.out.println("User history");
        // Retrieve the user history from the database and display it on the console
    }

    public void displayExitMessage() {
        System.out.println("Goodbye!");
    }
}