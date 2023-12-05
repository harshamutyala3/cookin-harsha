package com.cookin.cookin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {

    @GetMapping("/showRecipes")
    public String showRecipesPage() {
        return "recipes"; // Just the name without the file extension
    }
}

