package com.nutriapp;
import java.util.Map;

public class Ingredient {
    private String name;
    private int calorieCount;
    private Map<String, Integer> nutritionalInformation;
    private int stockAmount;

    public Ingredient(String name, int calorieCount, Map<String, Integer> nutritionalInformation, int stockAmount) {
        this.name = name;
        this.calorieCount = calorieCount;
        this.nutritionalInformation = nutritionalInformation;
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorieCount() {
        return calorieCount;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    public Map<String, Integer> getNutritionalInformation() {
        return nutritionalInformation;
    }

    public void setNutritionalInformation(Map<String, Integer> nutritionalInformation) {
        this.nutritionalInformation = nutritionalInformation;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}