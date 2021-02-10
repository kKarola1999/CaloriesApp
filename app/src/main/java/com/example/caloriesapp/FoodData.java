package com.example.caloriesapp;

import java.util.Map;

public class FoodData {

    private double sugar_g;
    private double fiber_g;
    private double serving_size_g;

    private String name;
    private double calories;
    private double cholesterol_mg;

    public FoodData(double sugar_g, double fiber_g, double serving_size_g, String name, double calories, double cholesterol_mg) {
        this.sugar_g = sugar_g;
        this.fiber_g = fiber_g;
        this.serving_size_g = serving_size_g;
        this.name = name;
        this.calories = calories;
        this.cholesterol_mg = cholesterol_mg;

    }

    @Override
    public String toString() {
        return "FoodData{" +
                "sugar_g=" + sugar_g +
                ", fiber_g=" + fiber_g +
                ", serving_size_g=" + serving_size_g +
                ", name=" + name +
                ", calories=" + calories +
                ", cholesterol_mg=" + cholesterol_mg +
                '}';
    }

    public double getSugar_g() {
        return sugar_g;
    }

    public void setSugar_g(double sugar_g) {
        this.sugar_g = sugar_g;
    }

    public double getFiber_g() {
        return fiber_g;
    }

    public void setFiber_g(double fiber_g) {
        this.fiber_g = fiber_g;
    }

    public double getServing_size_g() {
        return serving_size_g;
    }

    public void setServing_size_g(double serving_size_g) {
        this.serving_size_g = serving_size_g;
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

    public double getCholesterol_mg() {
        return cholesterol_mg;
    }

    public void setCholesterol_mg(double cholesterol_mg) {
        this.cholesterol_mg = cholesterol_mg;
    }


}


