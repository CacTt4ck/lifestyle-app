package com.cactt4ck.lifestyleapp.service;

import com.cactt4ck.lifestyleapp.model.Ingredient;
import com.cactt4ck.lifestyleapp.model.Recipe;
import com.cactt4ck.lifestyleapp.model.RecipeIngredient;
import com.cactt4ck.lifestyleapp.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingListService {

    private final IngredientRepository ingredientRepository;

    public ShoppingListService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    /*// Méthode pour générer une liste de courses en fonction d'une recette
    public Map<String, Double> generateShoppingList(Recipe recipe) {
        Map<String, Double> shoppingList = new HashMap<>();

        // Parcourir tous les ingrédients d'une recette
        for (RecipeIngredient recipeIngredient : recipe.getIngredients()) {
            Ingredient ingredient = recipeIngredient.getIngredient();
            double requiredQuantity = recipeIngredient.getQuantity();
            double currentStock = ingredient.getStock();

            // Si la quantité nécessaire est supérieure au stock, ajouter à la liste de courses
            if (requiredQuantity > currentStock) {
                double quantityToBuy = requiredQuantity - currentStock;
                shoppingList.put(ingredient.getName(), quantityToBuy);
            }
        }

        return shoppingList;
    }

    public void updateStockAfterRecipePreparation(Recipe recipe) {
        for (RecipeIngredient recipeIngredient : recipe.getIngredients()) {
            Ingredient ingredient = recipeIngredient.getIngredient();
            double quantityUsed = recipeIngredient.getQuantity();
            ingredient.setStock(ingredient.getStock() - quantityUsed);
            ingredientRepository.save(ingredient);
        }
    }*/

}

