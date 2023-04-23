package com.nutriapp.db;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import com.nutriapp.GainWeight;
import com.nutriapp.Goal;
import com.nutriapp.LoseWeight;
import com.nutriapp.MaintainWeight;
import com.nutriapp.User;

public class UserCSV {
    // this file will contain the CSV style database schema.
    // it will contain the methods to read and write to the database.
    // the "database" will simply be a csv file called users.csv
    /* a user has several characteristics:
     *  a string username
     *  a int height in inches
     *  a int weight in pounds
     *  a string birthdate that is used to calculate age
     *  a goal which is difined in ../goal.java
     */
    // the database will be a csv file with the following format:
    // name,height,weight,birthdate,goal

    // function to create a user (add a new user to users file)
    public static int createUser(User user) throws IOException {
        // create a new file if it doesn't exist
        File file = new File("data/users.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        // checks if the username already exists and return 0 if it does
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts[0].equals(user.getName())) {
                scanner.close();
                return 0;
            }
        }
        scanner.close();

        // write the user to the file
        FileWriter writer = new FileWriter("data/users.csv", true);
        writer.write(user.getName() + "," + user.getHeight() + "," + user.getWeight() + "," + user.getBirthdate() + "," + user.getGoal() + System.lineSeparator());
        writer.close();
        return 1;
    }

    public static int removeUser(User user) {
        // check if file exists, return 0 if it doesn't
        File file = new File("data/users.csv");
        if (!file.exists()) {
            return 0;
        }

        StringBuilder newFileContent = new StringBuilder();
        boolean userExists = false;

        try {
            // Read the file and store its content without the target user
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    continue;
                }
                if (!parts[0].equals(user.getName())) {
                    newFileContent.append(line).append(System.lineSeparator());
                } else {
                    userExists = true;
                }
            }
            scanner.close();

            // If the user does not exist, return 0
            if (!userExists) {
                return 0;
            }

            // Write the new content to the file
            FileWriter writer = new FileWriter("data/users.csv");
            writer.write(newFileContent.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // If the user exists and has been removed, return 1
        return 1;
    }

    public static int updateUser(User updatedUser, User user) {
        // check if file exists, return 0 if it doesn't
        File file = new File("data/users.csv");
        if (!file.exists()) {
            return 0;
        }

        StringBuilder newFileContent = new StringBuilder();
        boolean userExists = false;

        try {
            // Read the file and store its content with the new user information (only on the line with the matching username)
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(user.getName())) {
                    userExists = true;
                    newFileContent.append(updatedUser.getName() + "," + updatedUser.getHeight() + "," + updatedUser.getWeight() + "," + updatedUser.getBirthdate() + "," + updatedUser.getGoal() + System.lineSeparator());
                } else {
                    newFileContent.append(line).append(System.lineSeparator());
                }
            }
            scanner.close();

            if (!userExists) {
                return 0;
            }
            
            // Write the new content to the file
            FileWriter writer = new FileWriter("data/users.csv");
            writer.write(newFileContent.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public static User getUser(String username) {
        // check if file exists, return null if it doesn't
        File file = new File("data/users.csv");
        if (!file.exists()) {
            return null;
        }

        try {
            // Read the file and return the user with the matching username
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    scanner.close();

                    // convert parts[4] to Goal
                    Goal usergoal;
                    if (parts[4].equals("Lose Weight")) {
                        usergoal = new LoseWeight();
                    } else if (parts[4].equals("Maintain Weight")) {
                        usergoal = new MaintainWeight();
                    } else if (parts[4].equals("Gain Weight")) {
                        usergoal = new GainWeight();
                    } else {
                        usergoal = new MaintainWeight();
                    }

                    return new User(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), LocalDate.parse(parts[3]), usergoal);
                }
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
