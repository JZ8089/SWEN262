package com.nutriapp;

public class Ingredient {
    private String name;
    private double calories;
    private double gramsOfFat;
    private double gramsOfProtein;
    private double gramsOfFiber;
    private double gramsOfCarbohydrates;
    private double stock;

    public Ingredient(String name, double calories, double gramsOfFat, double gramsOfProtein, double gramsOfFiber, double gramsOfCarbohydrates) {
        this.name = name;
        this.calories = calories;
        this.gramsOfFat = gramsOfFat;
        this.gramsOfProtein = gramsOfProtein;
        this.gramsOfFiber = gramsOfFiber;
        this.gramsOfCarbohydrates = gramsOfCarbohydrates;
        this.stock = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getGramsOfFat() {
        return gramsOfFat;
    }

    public void setGramsOfFat(double gramsOfFat) {
        this.gramsOfFat = gramsOfFat;
    }

    public double getGramsOfProtein() {
        return gramsOfProtein;
    }

    public void setGramsOfProtein(double gramsOfProtein) {
        this.gramsOfProtein = gramsOfProtein;
    }

    public double getGramsOfFiber() {
        return gramsOfFiber;
    }

    public void setGramsOfFiber(double gramsOfFiber) {
        this.gramsOfFiber = gramsOfFiber;
    }

    public double getGramsOfCarbohydrates() {
        return gramsOfCarbohydrates;
    }

    public void setGramsOfCarbohydrates(double gramsOfCarbohydrates) {
        this.gramsOfCarbohydrates = gramsOfCarbohydrates;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public void use(double amount) {
        if (stock >= amount) {
            stock -= amount;
        } else {
            System.out.println("Error: " + name + " is out of stock.");
        }
    }

    public void purchase(double amount) {
        stock += amount;
    }
}
