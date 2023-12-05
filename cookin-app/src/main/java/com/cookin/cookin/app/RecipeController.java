package com.cookin.cookin.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public List<Recipe> getFilteredRecipes(
            @RequestParam(value = "ingredients", required = false) String ingredients,
            @RequestParam(value = "cuisine", required = false) String cuisine,
            @RequestParam(value = "mealTime", required = false) String mealTime) {
        return recipeService.filterRecipes(ingredients, cuisine, mealTime);
    }
}
