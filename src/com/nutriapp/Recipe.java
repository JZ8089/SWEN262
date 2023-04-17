package com.nutriapp;

import java.util.ArrayList;
import java.util.List;

class Recipe extends Food {
    private List<Food> ingredients = new ArrayList<>();
    private int stock;
  
    public Recipe(String name, int caloriesPerUnit, int fatPerUnit, int proteinPerUnit, int fiberPerUnit, int carbsPerUnit) {
        super(name, caloriesPerUnit, fatPerUnit, proteinPerUnit, fiberPerUnit, carbsPerUnit);
        this.ingredients = new ArrayList<>();
    }

    public int getStock() {
        return stock;
    }
  
    public void setStock(int stock) {
        this.stock = stock;
    }
  
    public int calculateTotalCalories(User user) {
      int totalCalories = 0;
      for (Food ingredient : ingredients) {
        totalCalories += ingredient.calculateTotalCalories(user);
      }
      return totalCalories;
    }
  
    public void addIngredient(Food ingredient) {
      this.ingredients.add(ingredient);
    }
  
    public void removeIngredient(Food ingredient) {
      this.ingredients.remove(ingredient);
    }
  
    public List<Food> getIngredients() {
      return this.ingredients;
    }
  }
  