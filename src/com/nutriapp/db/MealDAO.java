package com.nutriapp.db;

import com.nutriapp.Meal;


public interface MealDAO {
    void saveMeal(Meal meal);
    void deleteMeal(Meal meal);
}