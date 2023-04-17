package com.nutriapp;

import java.util.List;

public class AdvancedMeal implements Meal {
    private String name;
    private List<Recipe> recipes;

    public AdvancedMeal(String name, List<Recipe> recipes) {
        this.name = name;
        this.recipes = recipes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public void prepare(User user) {
        System.out.println("Preparing advanced meal...");
        double totalCalories = 0;
        for (Recipe recipe : recipes) {
            totalCalories += recipe.getCalories();
        }

        double portionSize = user.getDailyCalorieIntake() / totalCalories;
        for (Recipe recipe : recipes) {
            recipe.prepare(portionSize);
        }
    }
}
