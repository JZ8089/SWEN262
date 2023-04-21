package com.nutriapp;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nutriapp.db.MealCSV;
import com.nutriapp.db.UserCSV;


/*
 * This class is responsible for displaying the user interface.
 * It also handles user input.
 * it is not complete, and it doesnt actually reference anything. The equivelent of an unplugged controller.
 */
public class NutriAppUI {
    private Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>(); // This is where we will store the users (client-side)

    public void displayMenu() {
        System.out.println("Welcome to NutriApp!");
        System.out.println("1. Create a new user");
        System.out.println("2. Add a new meal");
        System.out.println("3. Add a new workout");
        System.out.println("4. Add length of day in seconds");
        System.out.println("5. View user history");
        System.out.println("6. Exit");
    }

    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void displayUserForm() {
        System.out.println("Create a new user");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your height (feet): ");
        double height = scanner.nextDouble();
        System.out.print("Enter your weight (lbs): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your birthdate (YYYY-MM-DD): ");
        String birthdate = scanner.next();
        // Save the user data to the database
        LocalDate birthDate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        User user = new User(name, height, weight, birthDate, null, null, null, 86400);
        try {
            UserCSV.createUser(user);
            users.add(user);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void displayMealForm() {
        System.out.println("Add a new meal");
        System.out.print("Enter the name of the meal: ");
        String mealName = scanner.next();
        // System.out.print("Enter the ingredients (comma separated): ");
        // String ingredients = scanner.next();

        // List<String> ingredientList = new ArrayList<>();
        // for (String ingredient : ingredients.split(",")) {
        //     ingredientList.add(ingredient);
        // }

        System.out.print("Enter the calories: ");
        int calories = scanner.nextInt();
        System.out.print("Enter the fat: ");
        int fat = scanner.nextInt();
        System.out.print("Enter the protein: ");
        int protein = scanner.nextInt();
        System.out.print("Enter the fiber: ");
        int fiber = scanner.nextInt();
        System.out.print("Enter the carbs: ");
        int carbs = scanner.nextInt();
        // Save the meal data to the database
        Meal meal = new Meal(mealName, calories, fat, protein, fiber, carbs);
        MealCSV.saveMeal(meal);

    }

    public void displayWorkoutForm() {
        System.out.println("Add a new workout");
        System.out.print("Enter the duration (in minutes): ");
        int duration = scanner.nextInt();
        System.out.print("Enter the intensity: ");
        String intensity = scanner.next();
        System.out.print("Enter the date (YYYY-MM-DD): ");
        String date = scanner.next();
        // Save the workout data to the databases
    }

    public void displayHoursLeftInDay() {
        User user = null;
        System.out.print("Which user would you like to modify the length of day for? ");
        String name = scanner.next();
        for(User u : users) {
            if(u.getName().equals(name)) {
                user = u;
            }
        } if(user == null) {
            System.out.println("Error: User not found!\n");
            return;
        }

        System.out.println("The modified day length should be the remaining time in the day.");
        System.out.print("Enter the duration (in seconds): ");
        double time = scanner.nextDouble();

        // Save the workout duration to the database
        User updatedUser = new User(user.getName(), user.getHeight(), user.getWeight(),user.getBirthdate(), user.getGoal(), user.getFoods(), user.getWorkoutStrategy(), time);
        UserCSV.updateUser(updatedUser, user);
    }

    

    public void displayUserHistory() {
        System.out.println("User history");
        
        // Retrieve the user history from the database and display it on the console
            File file = new File("users.csv");
            if (!file.exists()) {
                System.out.println("Error: No user file found!\n");
                return;
            }
    
            List<String[]> history = new ArrayList<>();

            try {
                System.out.print("Enter the name of the user whose history you would like to view: ");
                String name = scanner.next();
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] tokens = line.split(",");
                    if (tokens[0].equals(name)) {
                        history.add(tokens);
                    }
                }

                scanner.close();

                if(history.size() == 0) {
                    System.out.println("Error: User not found!\n");
                    return;
                }

                System.out.println("\nUser history:");
                for (String[] tokens : history) {
                    System.out.println("Username: " + tokens[0] + "\nHeight: " + tokens[1] + "\nWeight: " + tokens[2] + "\nBirthdate: " + tokens[3] + "\nCurrent Goal: " + tokens[4] + "Length of Day (seconds): " + tokens[5] + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
    }

    public void displayExitMessage() {
        System.out.println("Goodbye!");
    }
}