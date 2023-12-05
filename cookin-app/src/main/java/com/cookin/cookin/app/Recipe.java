package com.cookin.cookin.app;

import java.util.List;

public class Recipe {
    private String name;
    private String cuisine;
    private String mealTime;
    private String prepTime;
    private List<String> ingredients;
    private List<String> process;

    public Recipe(String name, String cuisine, String mealTime, String prepTime, List<String> ingredients, List<String> process) {
        this.name = name;
        this.cuisine = cuisine;
        this.mealTime = mealTime;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.process = process;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getProcess() {
        return process;
    }

    public void setProcess(List<String> process) {
        this.process = process;
    }
}
