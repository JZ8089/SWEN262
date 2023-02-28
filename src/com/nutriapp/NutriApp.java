package com.nutriapp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.nutriapp.*;

public class NutriApp {
    private Database database;
    private User user;
    private Meal currentMeal;
    private Workout currentWorkout;
    private Scanner scanner;

    public NutriApp() {
        this.database = new Database();
        this.user = null;
        this.currentMeal = null;
        this.currentWorkout = null;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        printWelcomeMessage();
        boolean quit = false;

        while (!quit) {
            printMenu();
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":
                    createUser();
                    break;
                case "2":
                    updateUser();
                    break;
                case "3":
                    deleteUser();
                    break;
                case "4":
                    // logMeal();
                    break;
                case "5":
                    // logWorkout();
                    break;
                case "6":
                    // printMealHistory();
                    break;
                case "7":
                    // printWorkoutHistory();
                    break;
                case "8":
                    // printUserHistory();
                    break;
                case "9":
                    // printCaloriesRemaining();
                    break;
                case "10":
                    // printRecommendedCalories();
                    break;
                case "11":
                    // printCurrentMeal();
                    break;
                case "12":
                    // printCurrentWorkout();
                    break;
                case "13":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using NutriApp!");
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to NutriApp!");
    }

    private void printMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Create User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. Log Meal");
        System.out.println("5. Log Workout");
        System.out.println("6. View Meal History");
        System.out.println("7. View Workout History");
        System.out.println("8. View User History");
        System.out.println("9. View Calories Remaining Today");
        System.out.println("10. View Recommended Calories Per Day");
        System.out.println("11. View Current Meal");
        System.out.println("12. View Current Workout");
        System.out.println("13. Quit");
    }

    private void createUser() {
        System.out.println("\nCreating new user...");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().trim();
        // ask user for their birthdate, and save it as LocalDate
        System.out.print("Please enter your birthdate (MM/DD/YYYY): ");
        String birthdateString = scanner.nextLine().trim();
        LocalDate birthdate = LocalDate.parse(birthdateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.print("Please enter your height in inches: ");
        int height = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please enter your weight in pounds: ");
        int weight = scanner.nextInt();
        scanner.nextLine();
        // System.out.print("Please enter your activity level (sedentary, moderate, or active): ");
        // String activityLevel = scanner.nextLine().trim().toLowerCase();
        System.out.print("Please enter your goal (maintain, lose, or gain): ");
        String goalString = scanner.nextLine().trim().toLowerCase();
        Goal goal = Goal.valueOf(goalString.toUpperCase() + "_WEIGHT");

        this.user = new User(name, height, weight, birthdate, goal);
        System.out.println("User created successfully.");
    }


    // write update user
    private void updateUser() {
        System.out.println("\nUpdating user...");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().trim();
        // ask user for their birthdate, and save it as LocalDate
        System.out.print("Please enter your birthdate (MM/DD/YYYY): ");
        String birthdateString = scanner.nextLine().trim();
        LocalDate birthdate = LocalDate.parse(birthdateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.print("Please enter your height in inches: ");
        int height = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please enter your weight in pounds: ");
        int weight = scanner.nextInt();
        scanner.nextLine();
        // System.out.print("Please enter your activity level (sedentary, moderate, or active): ");
        // String activityLevel = scanner.nextLine().trim().toLowerCase();
        System.out.print("Please enter your goal (maintain, lose, or gain): ");
        String goalString = scanner.nextLine().trim().toLowerCase();
        Goal goal = Goal.valueOf(goalString.toUpperCase() + "_WEIGHT");

        // use user setters to set 
        System.out.println("User updated successfully.");
    }

    // write delete user
    private void deleteUser() {
        System.out.println("\nDeleting user...");
        this.user = null;
        System.out.println("User deleted successfully.");
    }

    // private void logMeal() {
    //     System.out.println("\nLogging meal...");
    //     System.out.print("Please enter the meal name: ");
    //     String name = scanner.nextLine().trim();

    //     // this.currentMeal = new Meal(name);

    //     System.out.println("Please enter the food items (enter 'done' when finished):");
    //     String input = scanner.nextLine().trim();

    //     while (!input.equals("done")) {
    //         // Food food = database.getFood(input);

    //         if (food == null) {
    //             System.out.println("Food item not found. Please try again.");
    //         } else {
    //             // this.currentMeal.addFood(food);
    //         }

    //         input = scanner.nextLine().trim();
    //     }

    //     // this.user.logMeal(this.currentMeal);
    //     System.out.println("Meal logged successfully.");
    // }

}
