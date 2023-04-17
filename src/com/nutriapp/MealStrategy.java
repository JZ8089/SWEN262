package com.nutriapp;

import java.util.List;

public interface MealStrategy {
    List<Food> createMeal(User user);
}
