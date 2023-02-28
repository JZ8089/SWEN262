package com.nutriapp;
public class Food {
    private String name;
    private int calorieCount;
    private String nutritionalInfo;

    public Food(String name, int calorieCount, String nutritionalInfo) {
        this.name = name;
        this.calorieCount = calorieCount;
        this.nutritionalInfo = nutritionalInfo;
    }

    public String getName() {
        return name;
    }

    public int getCalorieCount() {
        return calorieCount;
    }

    public String getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    public void setNutritionalInfo(String nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }
}