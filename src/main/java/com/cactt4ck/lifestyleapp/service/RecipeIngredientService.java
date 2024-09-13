package com.cactt4ck.lifestyleapp.service;

import com.cactt4ck.lifestyleapp.model.Ingredient;
import com.cactt4ck.lifestyleapp.model.RecipeIngredient;
import com.cactt4ck.lifestyleapp.model.RecipeIngredientId;
import com.cactt4ck.lifestyleapp.repository.IngredientRepository;
import com.cactt4ck.lifestyleapp.repository.RecipeIngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeIngredientService {

    private static final Logger log = LoggerFactory.getLogger(RecipeIngredientService.class);
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository,
                                   IngredientRepository ingredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
    }

    // Ajouter une nouvelle relation entre recette et ingrédient
    public RecipeIngredient addRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    // Supprimer une relation entre recette et ingrédient
    public void deleteRecipeIngredient(Long id) {
        recipeIngredientRepository.deleteById(id);
    }

    // Obtenir une relation par ID
    public Optional<RecipeIngredient> getRecipeIngredientById(Long id) {
        return recipeIngredientRepository.findById(id);
    }
}

