package com.nutriapp;

import java.util.List;

public interface Meal {
    String getName();
    List<Recipe> getRecipes();
    void prepare(User user);
}
