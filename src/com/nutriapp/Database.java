package com.nutriapp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Map<String, Ingredient> ingredientMap = new HashMap<>();

    public static void addIngredient(Ingredient ingredient) {
        ingredientMap.put(ingredient.getName(), ingredient);
    }

    public static Ingredient getIngredient(String name) {
        return ingredientMap.get(name);
    }

    public static List<Ingredient> searchIngredients(String query) {
        List<Ingredient> result = new ArrayList<>();
        for (Ingredient ingredient : ingredientMap.values()) {
            if (ingredient.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(ingredient);
            }
        }
        return result;
    }
}