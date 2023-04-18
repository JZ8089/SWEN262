package com.nutriapp.db;

import com.nutriapp.Meal;

import java.io.*;

public class MealCSV implements MealDAO {
    private String filePath;

    public MealCSV(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveMeal(Meal meal) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {
            writer.println(meal.getName() + "," + meal.getCaloriesPerUnit() + "," + meal.getFatPerUnit() + ","
                    + meal.getProteinPerUnit() + "," + meal.getFiberPerUnit() + "," + meal.getCarbsPerUnit());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMeal(Meal meal) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = meal.getName();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public List<Meal> getAll() {
    //     List<Meal> meals = new ArrayList<>();
    //     try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             String[] parts = line.split(",");
    //             String name = parts[0];
    //             int caloriesPerUnit = Integer.parseInt(parts[1]);
    //             int fatPerUnit = Integer.parseInt(parts[2]);
    //             int proteinPerUnit = Integer.parseInt(parts[3]);
    //             int fiberPerUnit = Integer.parseInt(parts[4]);
    //             int carbsPerUnit = Integer.parseInt(parts[5]);

    //             Meal meal = new Meal(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbsPerUnit);
    //             meals.add(meal);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     return meals;
    // }
}