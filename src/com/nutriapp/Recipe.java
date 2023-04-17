package com.nutriapp;

import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;

    public Recipe(String name, List<Ingredient> ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructions() {
        return instructions;
    }

    public double getCalories() {
        double totalCalories = 0;
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.getCalories();
        }
        return totalCalories;
    }

    public void prepare(double portionSize) {
        System.out.println("Preparing recipe: " + name);
        for (Ingredient ingredient : ingredients) {
            double amount = ingredient.getStock() * portionSize / 100;
            ingredient.use(amount);
        }
    }
}
