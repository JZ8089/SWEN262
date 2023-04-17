package com.nutriapp;

import java.util.List;

public class Ingredient extends Food {
    private int stock;

    public Ingredient(String name, int caloriesPerUnit, int fatPerUnit, int proteinPerUnit, int fiberPerUnit, int carbsPerUnit, int stock) {
        super(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbsPerUnit);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int calculateTotalCalories(User user) {
        int totalCalories = (int) (caloriesPerUnit * user.getDailyCalorieIntake() / 2000);
        return totalCalories;
    }

    @Override
    public void addIngredient(Food ingredient) {
        throw new UnsupportedOperationException("Cannot add ingredient to an ingredient.");
    }

    @Override
    public void removeIngredient(Food ingredient) {
        throw new UnsupportedOperationException("Cannot remove ingredient from an ingredient.");
    }

    @Override
    public List<Food> getIngredients() {
        throw new UnsupportedOperationException("An ingredient does not have any ingredients.");
    }
}