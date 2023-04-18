package com.nutriapp;

import java.util.List;

/*
 * This interface is responsible for creating a meal.
 */
public interface MealStrategy {
    List<Food> createMeal(User user);
}
