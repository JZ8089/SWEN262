package com.nutriapp;

import java.util.List;

public class BasicMeal implements Meal {
    private String name;
    private List<Recipe> recipes;

    public BasicMeal(String name, List<Recipe> recipes) {
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
        System.out.println("Preparing basic meal...");
        double portionSize = user.getDailyCalorieIntake() / recipes.size();
        for (Recipe recipe : recipes) {
            recipe.prepare(portionSize);
        }
    }
}