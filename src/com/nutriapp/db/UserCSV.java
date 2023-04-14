package com.nutriapp.db;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.nutriapp.Goal;

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
    public static int createUser(String username, int height, int weight, String birthdate, Goal goal) throws IOException {
        // create a new file if it doesn't exist
        File file = new File("users.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        // checks if the username already exists and return 0 if it does
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts[0].equals(username)) {
                scanner.close();
                return 0;
            }
        }
        // write the user to the file
        FileWriter writer = new FileWriter("users.csv", true);
        writer.write(username + "," + height + "," + weight + "," + birthdate + "," + goal);
        writer.close();
        return 1;
    }

    public static int removeUser(String curUsername) {
        // check if file exists return 0 if it doesnt
        File file = new File("users.csv");
        if (!file.exists()) {
            return 0;
        }
        // since we are removing a user, we need to make sure the user exists
        // if the user does NOT exist, return 0

        // if the user does exist, remove the user from the file
        // return 1
        

    }


}
