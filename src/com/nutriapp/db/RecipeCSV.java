package com.nutriapp.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.nutriapp.Recipe;

public class RecipeCSV {
    private static final String FILENAME = "recipes.csv";

    public void saveRecipes(List<Recipe> recipes) {
        try (FileWriter fw = new FileWriter(FILENAME);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Recipe recipe : recipes) {
                out.println(recipe.getName() + "," + recipe.getCaloriesPerUnit() + "," + recipe.getFatPerUnit() + "," + recipe.getProteinPerUnit() + "," + recipe.getFiberPerUnit() + "," + recipe.getCarbsPerUnit() + "," + recipe.getStock());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> loadRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Recipe recipe = new Recipe(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]));
                recipe.setStock(Integer.parseInt(values[6]));
                recipes.add(recipe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipes;
    }
}