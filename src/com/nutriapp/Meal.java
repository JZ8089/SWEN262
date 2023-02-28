package com.nutriapp;
import java.util.ArrayList;

public class Meal {
    private String name;
    private ArrayList<Recipe> recipes;

    public Meal(String name, ArrayList<Recipe> recipes) {
        this.name = name;
        this.recipes = recipes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (Recipe recipe : recipes) {
            totalCalories += recipe.getTotalCalories();
        }
        return totalCalories;
    }
}
