package com.cookin.cookin.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final List<Recipe> recipes;

    public RecipeService() {
        recipes = new ArrayList<>(Arrays.asList(
                new Recipe("Chicken Parmesan", "Italian", "dinner", "30 minutes",
                        Arrays.asList("chicken", "flour", "eggs", "breadcrumbs", "marinara sauce", "mozzarella cheese"),
                        Arrays.asList("Preheat the oven to 375°F.", "Coat chicken breasts in flour, eggs, and breadcrumbs.", "Brown the chicken in a skillet.", "Top with marinara sauce and mozzarella cheese.", "Bake in the oven for 20-25 minutes.")
                ),
                new Recipe("Taco Salad", "Mexican", "lunch", "15 minutes",
                        Arrays.asList("ground beef", "taco seasoning", "lettuce", "eggs", "tomatoes", "cheddar cheese", "tortilla chips"),
                        Arrays.asList("Brown the ground beef in a skillet.", "Add taco seasoning and stir to combine.", "Assemble salad with lettuce, tomatoes, cheddar cheese, and tortilla chips.", "Top with ground beef.")
                ),
                new Recipe("Chicken Fajitas", "Mexican", "dinner", "30 minutes",
                        Arrays.asList("chicken", "bell peppers", "onion", "taco seasoning", "tortillas", "sour cream", "guacamole"),
                        Arrays.asList("Slice chicken and bell peppers into strips.", "Sauté chicken, peppers, and onions with taco seasoning.", "Warm tortillas in a pan.", "Assemble fajitas with cooked ingredients.", "Serve with sour cream and guacamole.")
                ),
                new Recipe("Pasta Carbonara", "Italian", "dinner", "20 minutes",
                        Arrays.asList("spaghetti", "pancetta", "eggs", "Parmesan cheese", "black pepper"),
                        Arrays.asList("Cook spaghetti according to package instructions.", "Sauté pancetta until crispy.", "Whisk eggs, Parmesan, and black pepper in a bowl.", "Mix hot pasta with egg mixture.", "Add pancetta and toss. Serve immediately.")
                ),
                new Recipe("Vegetable Stir-Fry", "Indian", "dinner", "15 minutes",
                        Arrays.asList("broccoli", "carrots", "bell peppers", "snow peas", "tofu", "soy sauce", "sesame oil"),
                        Arrays.asList("Cut tofu into cubes and stir-fry until golden.", "Add chopped vegetables and stir-fry until tender.", "Drizzle with soy sauce and sesame oil.", "Toss together and serve.")
                ),
                new Recipe("Chicken Biryani", "Indian", "dinner", "60 minutes",
                        Arrays.asList("chicken", "basmati rice", "onions", "yogurt", "ginger-garlic paste", "spices: cumin, coriander, garam masala", "saffron", "mint leaves"),
                        Arrays.asList("Marinate chicken in yogurt, spices, and ginger-garlic paste.", "Partially cook basmati rice.", "Layer marinated chicken and rice in a pot with fried onions, saffron, and mint.", "Cover and cook until the chicken is done and rice is fully cooked.")
                ),
                new Recipe("Paneer Tikka", "Indian", "appetizer", "30 minutes",
                        Arrays.asList("paneer (Indian cheese)", "bell peppers", "onions", "yogurt", "spices: cumin, turmeric, chili powder", "lemon juice"),
                        Arrays.asList("Cut paneer, bell peppers, and onions into cubes.", "Marinate in a mix of yogurt, spices, and lemon juice.", "Skewer and grill until lightly charred.")
                ),
                new Recipe("Chana Masala", "Indian", "dinner", "40 minutes",
                        Arrays.asList("chickpeas", "onions", "tomatoes", "garlic", "ginger", "spices: cumin, coriander, turmeric, garam masala", "green chilies", "fresh coriander"),
                        Arrays.asList("Sauté onions, garlic, and ginger.", "Add spices and cook until fragrant.", "Stir in tomatoes and chickpeas.", "Simmer until flavors meld. Garnish with green chilies and coriander.")
                ),
                new Recipe("Palak Paneer", "Indian", "dinner", "45 minutes",
                        Arrays.asList("paneer (Indian cheese)", "spinach", "onions", "tomatoes", "ginger", "spices: cumin, coriander, turmeric", "cream", "garam masala"),
                        Arrays.asList("Blanch spinach, then purée it.", "Sauté onions, ginger, and spices.", "Add tomatoes, then spinach purée.", "Stir in paneer cubes and cream. Simmer until heated through.")
                )







                // Add more recipes...
        ));
    }

    public List<Recipe> filterRecipes(String ingredients, String cuisine, String mealTime) {
        List<String> ingredientFilters = Arrays.asList(ingredients.toLowerCase().split(","));
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            List<String> recipeIngredients = recipe.getIngredients().stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

            boolean containsAllIngredients = recipeIngredients.containsAll(ingredientFilters);

            if (containsAllIngredients && recipe.getCuisine().toLowerCase().contains(cuisine.toLowerCase()) &&
                    recipe.getMealTime().toLowerCase().contains(mealTime.toLowerCase())) {
                filteredRecipes.add(recipe);
            }
        }
        return filteredRecipes;
    }
}
