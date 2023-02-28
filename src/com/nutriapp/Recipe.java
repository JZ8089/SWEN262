package com.nutriapp;
import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients;
    private String instructions;

    public Recipe(String name, ArrayList<Ingredient> ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.getCalorieCount();
        }
        return totalCalories;
    }
}