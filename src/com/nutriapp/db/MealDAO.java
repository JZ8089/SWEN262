package com.nutriapp.db;

import com.nutriapp.Meal;

/*
 * This interface is responsible for saving and deleting meals to a CSV file.
 */
public interface MealDAO {
    void saveMeal(Meal meal);
    void deleteMeal(Meal meal);
}









