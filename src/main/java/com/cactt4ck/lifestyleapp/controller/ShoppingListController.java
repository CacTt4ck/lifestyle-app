package com.cactt4ck.lifestyleapp.controller;

import com.cactt4ck.lifestyleapp.model.Recipe;
import com.cactt4ck.lifestyleapp.repository.RecipeRepository;
import com.cactt4ck.lifestyleapp.service.ShoppingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ShoppingListController {

    private final ShoppingListService shoppingListService;
    private final RecipeRepository recipeRepository;

    public ShoppingListController(ShoppingListService shoppingListService, RecipeRepository recipeRepository) {
        this.shoppingListService = shoppingListService;
        this.recipeRepository = recipeRepository;
    }

    /*@GetMapping("/recipes/{id}/shopping-list")
    public Map<String, Double> getShoppingList(@PathVariable Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        return shoppingListService.generateShoppingList(recipe);
    }*/
}
