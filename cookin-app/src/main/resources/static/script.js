function filterRecipes() {
    const ingredientFilter = document.getElementById("ingredient-filter").value;
    const cuisineFilter = document.getElementById("cuisine-filter").value;
    const mealTimeFilter = document.getElementById("meal-time-filter").value;

    fetch('http://localhost:8080/recipes?ingredients=' + ingredientFilter + '&cuisine=' + cuisineFilter + '&mealTime=' + mealTimeFilter)
        .then(response => response.json())
        .then(recipes => displayRecipes(recipes))
        .catch(error => console.error('Error:', error));
}

function displayRecipes(recipes) {
    const recipeList = document.getElementById("recipe-list");
    recipeList.innerHTML = "";

    recipes.forEach(recipe => {
        const recipeItem = document.createElement("li");
        recipeItem.textContent = `${recipe.name} (${recipe.cuisine}): ${recipe.ingredients.join(", ")} - Prep Time: ${recipe.prepTime}`;

        const processList = document.createElement("ul");
        recipe.process.forEach(step => {
            const processItem = document.createElement("li");
            processItem.textContent = step;
            processList.appendChild(processItem);
        });

        recipeItem.appendChild(processList);
        recipeList.appendChild(recipeItem);
    });
}
